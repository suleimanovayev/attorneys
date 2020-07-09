package attorneys.sites.thread;

import attorneys.sites.HtmlConverter;
import attorneys.sites.gflegal.GflegalAttorneyParser;
import attorneys.sites.gflegal.constant.GflegalConstants;
import attorneys.sites.hellsell.HellSellAttorneyParser;
import attorneys.sites.hellsell.constant.HellSellConstants;
import attorneys.sites.factory.ScraperServiceFactory;
import attorneys.sites.model.Attorney;
import attorneys.sites.service.ScraperService;
import org.omg.SendingContext.RunTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class SitesRunner {
    private static List<String> URLS = Arrays.asList(
            GflegalAttorneyParser.GFLEGAL_URL,
            HellSellAttorneyParser.HELL_SELL_URL
    );

    public void runSites() throws InterruptedException, ExecutionException {
        ExecutorService executorServiceSites = Executors
                .newFixedThreadPool(URLS.size());
        ExecutorService executorServiceAttorneys = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Future<List<String>> futureSites = null;
        List<Attorney> attorneys = new ArrayList<>();
        for (String url : URLS) {
            futureSites = executorServiceSites.submit(new SiteThread(url));
        }

        List<String> links = futureSites.get();

        for (String link : links) {
            Future<Attorney> futureAttorney = executorServiceAttorneys.submit(new Callable<Attorney>() {
                public Attorney call() throws Exception {
                    String html = HtmlConverter.getHtmlPage(link);
                    ScraperService service = ScraperServiceFactory.getScrapperServiceInstance(url);
                    Attorney attorney = service.getAttorney(html);
                    attorneys.add(attorney);
                    return attorney;
                }
            });
        }
        executorServiceSites.shutdown();
        executorServiceAttorneys.shutdown();
    }
}
