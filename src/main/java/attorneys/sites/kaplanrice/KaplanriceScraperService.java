package attorneys.sites.kaplanrice;

import attorneys.sites.HtmlConverter;
import attorneys.sites.service.AttorneyParser;
import attorneys.sites.service.ScraperService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;
import java.util.stream.Collectors;

public class KaplanriceScraperService extends ScraperService {
    public static final String KMCLLAW_URL = "http://www.kaplanrice.com/lawyers.html";
    public static final String ALL_ATTORNEYS_LINKS = "#interior-sidebar p.sidebar-heading2 a";

    public KaplanriceScraperService(AttorneyParser parser) {
        super(parser);
    }

    @Override
    public List<String> findAllAttorneysLinks(String linkOfSite) {
        String html = HtmlConverter.getHtmlPageFromJsoup(linkOfSite);
        Document document = Jsoup.parse(html);
        return document.select(ALL_ATTORNEYS_LINKS).stream()
                .map(attorney -> StringUtils.substringBeforeLast(KMCLLAW_URL, "lawyers") + attorney.attr("href"))
                .collect(Collectors.toList());

    }
}
