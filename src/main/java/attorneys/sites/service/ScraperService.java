package attorneys.sites.service;

import attorneys.sites.model.Attorney;

import java.util.List;


public abstract class ScraperService {

    public abstract List<Attorney> loadAttorneys(String siteUrl, AttorneyParser parser);

    public abstract Attorney getAttorney(String html, AttorneyParser parser);

    public abstract List<String> findAllAttorneysLinks(String linkOfSite);
}
