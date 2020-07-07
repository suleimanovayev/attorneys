package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupNameParser {

    public static String resolveName(String html) {
        Document document = Jsoup.parse(html);
        return "";
    }

}
