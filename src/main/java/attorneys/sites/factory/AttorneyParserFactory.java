package attorneys.sites.factory;

import attorneys.sites.constant.GflegalConstants;
import attorneys.sites.constant.HellSellConstants;
import attorneys.sites.gflegal.GflegalAttorneyParser;
import attorneys.sites.hellsell.HellSellAttorneyParser;
import attorneys.sites.hellsell.HellSellScrapperService;
import attorneys.sites.service.AttorneyParser;

import java.util.NoSuchElementException;

public class AttorneyParserFactory {
    private static AttorneyParser attorneyParser;


    public static AttorneyParser getAttorneyParserInstance(String linkOfSite) {
        if (linkOfSite.equals(GflegalConstants.GFLEGAL_URL)) {
            attorneyParser = new GflegalAttorneyParser();
        } else if (linkOfSite.equals(HellSellConstants.HELL_SELL_URL)) {
            attorneyParser = new HellSellAttorneyParser();
        } else {
            throw new NoSuchElementException("Site is not found");
        }
        return attorneyParser;
    }
}
