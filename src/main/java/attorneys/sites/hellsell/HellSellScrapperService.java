package attorneys.sites.hellsell;

import attorneys.sites.HtmlConverter;
import attorneys.sites.service.AttorneyParser;
import attorneys.sites.service.ScraperService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;
import java.util.stream.Collectors;

public class HellSellScrapperService extends ScraperService {
    public final static String ALL_ATTORNEY_LINKS = ".small-block-grid-2 >li >div[class=attorney-card] >a";

    public HellSellScrapperService(AttorneyParser parser) {
        super(parser);
    }

    @Override
    public List<String> findAllAttorneysLinks(String linkOfSite) {
        String html = HtmlConverter.getHtmlPageFromJsoup(linkOfSite);
        Document document = Jsoup.parse(html);
        return document.select(ALL_ATTORNEY_LINKS).stream().map(attorney -> attorney.attr("href"))
                .collect(Collectors.toList());
    }
}
