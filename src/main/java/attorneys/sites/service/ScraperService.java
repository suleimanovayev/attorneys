package attorneys.sites.service;

import attorneys.sites.model.Attorney;

import java.util.List;


public abstract class ScraperService {
    protected AttorneyParser parser;

    public abstract List<Attorney> loadAttorneys(String siteUrl);

    public abstract Attorney getAttorney(String html);

    public abstract List<String> findAllAttorneysLinks(String linkOfSite);
}
