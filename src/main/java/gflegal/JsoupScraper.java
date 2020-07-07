package gflegal;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class JsoupScraper {

    public List<String> findAttorneysLinks(Document document) {
        Elements allAttorneys = document.select("ul >li[itemprop='member'] >a");
        String baseUri = document.baseUri();
        return allAttorneys
                .stream()
                .map(attorney -> baseUri + StringUtils.substringAfterLast(allAttorneys.attr("href"), "/"))
                .collect(Collectors.toList());
    }
}
