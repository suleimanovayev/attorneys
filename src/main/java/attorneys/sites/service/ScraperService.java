package attorneys.sites.service;

import attorneys.sites.HtmlConverter;
import attorneys.sites.model.Attorney;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public abstract class ScraperService {
    protected AttorneyParser parser;

    public ScraperService(AttorneyParser parser) {
        this.parser = parser;
    }

    public List<Attorney> loadAttorneys(String siteUrl) throws IOException {
        List<Attorney> lawyers = new ArrayList<>();
        List<String> links = findAllAttorneysLinks(siteUrl);
        for (String link : links) {
            String html = HtmlConverter.getHtmlPage(link);
            Attorney attorney = getAttorney(html);
            lawyers.add(attorney);
            System.out.println(attorney);

        }
        return lawyers;
    }

    public Attorney getAttorney(String html) throws IOException {
        Attorney attorney = new Attorney();
        attorney.setName(parser.resolveName(html));
        attorney.setTitle(parser.resolveTitle(html));
        attorney.setLocations(parser.resolveLocation(html));
        attorney.setPhone(parser.resolvePhone(html));
        attorney.setEmail(parser.resolveEmail(html));
        attorney.setBarAdmissions(parser.resolveBarAdmissions(html));
        attorney.setFullBiography(parser.resolveFullBiography(html));
        attorney.setBiography(parser.resolveBiography(html));
        String education = parser.resolveEducation(html);
        attorney.setEducation(education);
        return attorney;
    }

    public abstract List<String> findAllAttorneysLinks(String linkOfSite);
    public abstract String getMainLinkByAttorneyLink(String attorneyLink);
}
