package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupLocationParser {

    public static String[] resolveLocation(String html) {
        Document document = Jsoup.parse(html);
        return new String[3];
    }
}
