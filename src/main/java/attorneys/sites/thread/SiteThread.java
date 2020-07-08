package attorneys.sites.thread;

import attorneys.sites.HtmlConverter;
import attorneys.sites.factory.ScraperServiceFactory;
import attorneys.sites.model.Attorney;
import attorneys.sites.service.ScraperService;

import java.util.List;
import java.util.concurrent.Callable;

public class SiteThread implements Callable<List<Attorney>> {
    private String urlOfSite;

    public SiteThread(String urlOfSite) {
        this.urlOfSite = urlOfSite;
    }

    @Override
    public List<Attorney> call() throws Exception {
        String htmlOfSite = HtmlConverter.getHtmlPage(urlOfSite);
        ScraperService service = ScraperServiceFactory.getScrapperServiceInstance(urlOfSite);
        return service.loadAttorneys(urlOfSite);
    }
}
