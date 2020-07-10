package attorneys.sites.thread;

import attorneys.sites.HtmlConverter;
import attorneys.sites.factory.ScraperServiceFactory;
import attorneys.sites.gflegal.GflegalAttorneyParser;
import attorneys.sites.hellsell.HellSellAttorneyParser;
import attorneys.sites.model.Attorney;
import attorneys.sites.service.ScraperService;

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

        List<Future<AttorneysLinksWrapper>> futureSites = new ArrayList<>();
        List<Future<Attorney>> attorneysFutures = new ArrayList<>();
        List<Attorney> attorneys = new ArrayList<>();

        for (String url : URLS) {
            futureSites.add(executorServiceSites.submit(new SiteThread(url)));
        }

        for (Future<AttorneysLinksWrapper> future : futureSites) {
            AttorneysLinksWrapper wrapper = future.get();
            String siteUrl = wrapper.getSiteUrl();
            List<String> links = wrapper.getUrls();
            for (String attorneyLink : links) {
                Future<Attorney> futureAttorney = executorServiceAttorneys.submit(new Callable<Attorney>() {
                    public Attorney call() throws Exception {
                        String html = HtmlConverter.getHtmlPageFromJsoup(attorneyLink);
                        ScraperService service = ScraperServiceFactory.getScrapperServiceInstance(siteUrl);
                        Attorney attorney = service.getAttorney(html);
                        attorneys.add(attorney);
                        return attorney;
                    }
                });
                attorneysFutures.add(futureAttorney);
            }
        }

        for (Future<Attorney> future : attorneysFutures) {
            Attorney attorney = future.get();
            System.out.println(attorney);
        }

        executorServiceSites.shutdown();
        executorServiceAttorneys.shutdown();
    }
}


class AttorneysLinksWrapper {
    String siteUrl;
    List<String> urls;

    public AttorneysLinksWrapper(String siteUrl, List<String> urls) {
        this.siteUrl = siteUrl;
        this.urls = urls;
    }

    public AttorneysLinksWrapper() {
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
