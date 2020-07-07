package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupBiographyParser {

    public static String resolveBiography(String html) {
        Document document = Jsoup.parse(html);
        return "";
    }
}
