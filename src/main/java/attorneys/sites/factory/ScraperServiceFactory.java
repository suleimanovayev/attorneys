package attorneys.sites.factory;

import attorneys.sites.constant.GflegalConstants;
import attorneys.sites.constant.HellSellConstants;
import attorneys.sites.gflegal.GflegalScraperService;
import attorneys.sites.hellsell.HellSellScrapperService;
import attorneys.sites.service.ScraperService;

import java.util.NoSuchElementException;

public class ScraperServiceFactory {
    private static ScraperService scraperService;

    public static ScraperService getScrapperServiceInstance(String linkOfSite) {
        if (linkOfSite.equals(GflegalConstants.GFLEGAL_URL)) {
            scraperService = new GflegalScraperService();
        } else if (linkOfSite.equals(HellSellConstants.HELL_SELL_URL)) {
            scraperService = new HellSellScrapperService();
        } else {
            throw new NoSuchElementException("Site is not found");
        }
        return scraperService;
    }
}
