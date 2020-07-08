package attorneys.sites.hellsell;

import attorneys.sites.HtmlConverter;
import attorneys.sites.hellsell.constant.HellSellConstants;
import attorneys.sites.service.ScraperService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;
import java.util.stream.Collectors;

public class HellSellScrapperService extends ScraperService {

    public HellSellScrapperService() {
        super.parser = new HellSellAttorneyParser();
    }

    @Override
    public List<String> findAllAttorneysLinks(String linkOfSite) {
        String html = HtmlConverter.getHtmlPage(linkOfSite);
        Document document = Jsoup.parse(html);
        return document.select(HellSellConstants.ALL_ATTORNEY_LINKS).stream().map(attorney -> attorney.attr("href"))
                .collect(Collectors.toList());
    }
}
