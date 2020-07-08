package attorneys.sites.factory;

import attorneys.sites.gflegal.GflegalScraperService;
import attorneys.sites.gflegal.constant.GflegalConstants;
import attorneys.sites.hellsell.HellSellScrapperService;
import attorneys.sites.hellsell.constant.HellSellConstants;
import attorneys.sites.service.ScraperService;

import java.util.NoSuchElementException;

public class ScraperServiceFactory {
    private ScraperService scraperService;

    public static ScraperService getScrapperServiceInstance(String linkOfSite) {
        if (linkOfSite.equals(GflegalConstants.GFLEGAL_URL)) {
            return new GflegalScraperService();
        } else if (linkOfSite.equals(HellSellConstants.HELL_SELL_URL)) {
            return new HellSellScrapperService();
        } else {
            throw new NoSuchElementException("Site is not found");
        }
    }
}
