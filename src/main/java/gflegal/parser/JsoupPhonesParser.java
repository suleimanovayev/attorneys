package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupPhonesParser {

    public static String[] resolvePhone(String html) {
        Document document = Jsoup.parse(html);
        return new String[3];
    }
}
