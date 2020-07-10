package attorneys.sites.kmcllaw;

import attorneys.sites.HtmlConverter;
import attorneys.sites.service.AttorneyParser;
import attorneys.sites.service.ScraperService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;
import java.util.stream.Collectors;

public class KmcllawScraperService extends ScraperService {
    public static final String ALL_ATTORNEYS_LINKS = "a.attorney-thumb-image";
    public static final String EMPTY_EDUCATION = "div.attorneyProfileNarrative, strong:contains(Education:) + ul li";

    public KmcllawScraperService(AttorneyParser parser) {
        super(parser);
    }

    @Override
    public List<String> findAllAttorneysLinks(String linkOfSite) {
        String html = HtmlConverter.getHtmlPageFromJsoup(linkOfSite);
        Document document = Jsoup.parse(html);
        return document.select(ALL_ATTORNEYS_LINKS).stream()
                .map(attorney -> attorney.attr("href"))
                .collect(Collectors.toList());
    }
}
