package gflegal;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.stream.Collectors;

public class JsoupScraper {

    public List<String> findAttorneysLinks(Document document) {
        Elements allAttorneys = document.select("ul >li[itemprop='member'] >a");
        return allAttorneys
                .stream()
                .map(attorney -> allAttorneys.attr("a[href]"))
                .collect(Collectors.toList());
    }
}
