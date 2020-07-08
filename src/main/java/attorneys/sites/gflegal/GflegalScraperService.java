package attorneys.sites.gflegal;

import attorneys.sites.HtmlConverter;
import attorneys.sites.constant.GflegalConstants;
import attorneys.sites.model.Attorney;
import attorneys.sites.service.AttorneyParser;
import attorneys.sites.service.ScraperService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GflegalScraperService extends ScraperService {

    public GflegalScraperService() {
        super.parser = new GflegalAttorneyParser();
    }

    public List<Attorney> loadAttorneys(String siteUrl) {
        List<Attorney> lawyers = new ArrayList<>();
        List<String> links = findAllAttorneysLinks(siteUrl);
        for (String link : links) {
            Attorney attorney = getAttorney(link);
            lawyers.add(attorney);
            System.out.println(attorney);

        }
        return lawyers;
    }

    public Attorney getAttorney(String html) {
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

    public List<String> findAllAttorneysLinks(String linkOfSite) {
        String html = HtmlConverter.getHtmlPage(linkOfSite);
        Elements allAttorneys = Jsoup.parse(html).select(GflegalConstants.ALL_ATTORNEYS_LINKS);
        return allAttorneys
                .stream()
                .map(attorney -> linkOfSite + StringUtils.substringAfterLast(attorney.attr("href"), "/"))
                .collect(Collectors.toList());
    }

        private void checkEducation(String education, String html) {
//        if (education.isEmpty()) {
//            education = parser.resolveEmptyEducation(html);
//        }
    }
}
