package attorneys.sites.hellsell;

import attorneys.sites.model.Attorney;
import attorneys.sites.service.AttorneyParser;
import attorneys.sites.service.ScraperService;

import java.util.List;

public class HellSellScrapperService extends ScraperService {
    @Override
    public List<Attorney> loadAttorneys(String siteUrl, AttorneyParser parser) {
        return null;
    }

    @Override
    public Attorney getAttorney(String html, AttorneyParser parser) {
        return null;
    }

    @Override
    public List<String> findAllAttorneysLinks(String linkOfSite) {
        return null;
    }
}
