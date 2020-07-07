package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupEducationParser {

    public static String resolveEducation(String html) {
        Document document = Jsoup.parse(html);
        return "";
    }
}
