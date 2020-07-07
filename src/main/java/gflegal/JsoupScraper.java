package gflegal;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class JsoupScraper {

    public static List<String> findAttorneysLinks(Document document) {
        Elements allAttorneys = document.select("ul >li[itemtype='http://schema.org/Person'] >a");
        String baseUri = document.baseUri();
        return allAttorneys
                .stream()
                .map(attorney -> baseUri + StringUtils.substringAfterLast(attorney.attr("href"), "/"))
                .collect(Collectors.toList());
    }
}
