package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupEmailParser {
    private static final String EMAIL = "div.attorneyProfileFax >a";

    public static String resolveEmail(String html) {
        Document document = Jsoup.parse(html);
        return document.select(EMAIL).text();
    }
}
