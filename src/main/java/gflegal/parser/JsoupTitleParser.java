package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupTitleParser {
    private static final String TITLE = "div.attorneyProfilePosition";

    public static String resolveTitle(String html) {
        Document document = Jsoup.parse(html);
        return document.select(TITLE).text();
    }
}
