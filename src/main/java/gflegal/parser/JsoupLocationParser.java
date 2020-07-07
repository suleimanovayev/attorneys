package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupLocationParser {
    private static final String LOCATION = "div.attorneyProfileLocation";

    public static String[] resolveLocation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(LOCATION)
                .get(0)
                .text()
                .split(",");
    }
}
