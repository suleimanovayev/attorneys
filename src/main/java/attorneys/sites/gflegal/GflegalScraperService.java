package attorneys.sites.gflegal;

import attorneys.sites.HtmlConverter;
import attorneys.sites.gflegal.constant.GflegalConstants;
import attorneys.sites.model.Attorney;
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

    public List<String> findAllAttorneysLinks(String linkOfSite) {
        String html = HtmlConverter.getHtmlPage(linkOfSite);
        Elements allAttorneys = Jsoup.parse(html).select(GflegalConstants.ALL_ATTORNEYS_LINKS);
        return allAttorneys
                .stream()
                .map(attorney -> linkOfSite + StringUtils.substringAfterLast(attorney.attr("href"), "/"))
                .collect(Collectors.toList());
    }

        private void checkEducation(String education, String html) {
        if (education.isEmpty()) {
            education = resolveEmptyEducation(html);
        }
    }

    public static String resolveEmptyEducation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(GflegalConstants.EMPTY_EDUCATION)
                .text();
    }
}
