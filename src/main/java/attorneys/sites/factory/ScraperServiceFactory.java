package attorneys.sites.factory;

import attorneys.sites.gflegal.GflegalAttorneyParser;
import attorneys.sites.gflegal.GflegalScraperService;
import attorneys.sites.hellsell.HellSellAttorneyParser;
import attorneys.sites.hellsell.HellSellScrapperService;
import attorneys.sites.service.ScraperService;

import java.util.NoSuchElementException;

public class ScraperServiceFactory {

    public static ScraperService getScrapperServiceInstance(String linkOfSite) {
        if (linkOfSite.equals(GflegalAttorneyParser.GFLEGAL_URL)) {
            return new GflegalScraperService(new GflegalAttorneyParser());
        } else if (linkOfSite.equals(HellSellAttorneyParser.HELL_SELL_URL)) {
            return new HellSellScrapperService(new HellSellAttorneyParser());
        } else {
            throw new NoSuchElementException("Site is not found");
        }
    }
}
