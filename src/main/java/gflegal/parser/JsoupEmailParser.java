package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupEmailParser {

    public static String resolveEmail(String html) {
        Document document = Jsoup.parse(html);
        return "";
    }
}
