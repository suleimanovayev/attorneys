package attorneys.sites.factory;

import attorneys.sites.constant.GflegalConstants;
import attorneys.sites.service.AttorneyAttributesParser;
import attorneys.sites.service.impl.GflegalAttributesParser;

import java.util.NoSuchElementException;

public class AttorneyAttributesFactory {
    private static AttorneyAttributesParser attorneyAttributesParser;

    public static AttorneyAttributesParser getAttorneyAttributesParserInstance(String linkOfSite) {
        if (linkOfSite.equals(GflegalConstants.GFLEGAL_URL)) {
            attorneyAttributesParser = new GflegalAttributesParser();
        } else {
            throw new NoSuchElementException("Site is not found");
        }
        return attorneyAttributesParser;
    }
}
