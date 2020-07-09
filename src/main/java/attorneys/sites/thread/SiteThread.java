package attorneys.sites.thread;

import attorneys.sites.factory.ScraperServiceFactory;
import attorneys.sites.service.ScraperService;

import java.util.List;
import java.util.concurrent.Callable;

public class SiteThread implements Callable<AttorneysLinksWrapper> {
    private String urlOfSite;

    public SiteThread(String urlOfSite) {
        this.urlOfSite = urlOfSite;
    }

    @Override
    public AttorneysLinksWrapper call() throws Exception {
        ScraperService service = ScraperServiceFactory.getScrapperServiceInstance(urlOfSite);
        List<String> urls = service.findAllAttorneysLinks(urlOfSite);
        return new AttorneysLinksWrapper(urlOfSite,urls);
    }
}
