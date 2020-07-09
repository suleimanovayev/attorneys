package attorneys.sites.service;

import java.util.List;

public class DefaultScrapperService extends ScraperService{
    public DefaultScrapperService(AttorneyParser parser) {
        super(parser);
    }

    @Override
    public List<String> findAllAttorneysLinks(String linkOfSite) {
        return null;
    }
}
