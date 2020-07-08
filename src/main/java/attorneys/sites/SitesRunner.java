package attorneys.sites;

import attorneys.sites.constant.GflegalConstants;
import attorneys.sites.constant.HellSellConstants;
import attorneys.sites.factory.ScraperServiceFactory;
import attorneys.sites.model.Attorney;
import attorneys.sites.service.ScraperService;
import attorneys.sites.thread.SiteThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SitesRunner {
    private static List<String> urls = Arrays.asList(
            GflegalConstants.GFLEGAL_URL,
            HellSellConstants.HELL_SELL_URL
    );

    public static void runSites() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors
                .newFixedThreadPool(urls.size());

        List<List<Attorney>> attorneys = new ArrayList<>();
        for (String url : urls) {
            ScraperService service = ScraperServiceFactory.getScrapperServiceInstance(url);
            Future<List<Attorney>> future = executorService.submit(new SiteThread(url));
            attorneys.add(future.get());
        }
        executorService.shutdown();
    }
}
