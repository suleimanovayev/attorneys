package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupPhoneParser {
    private static final String PHONE = "div.attorneyProfilePhone";

    public static String resolvePhone(String html) {
        Document document = Jsoup.parse(html);
        return document.select(PHONE)
                .text();
    }
}
