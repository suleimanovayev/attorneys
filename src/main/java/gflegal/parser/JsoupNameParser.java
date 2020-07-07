package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupNameParser {
    private static final String NAME = "div#containerPageTitle >h1";

    public static String resolveName(String html) {
        Document document = Jsoup.parse(html);
        return document.select(NAME).text();
    }

}
