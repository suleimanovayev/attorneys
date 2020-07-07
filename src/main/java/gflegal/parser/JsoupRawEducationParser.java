package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupRawEducationParser {

    public static String[] resolveRawEducation(String html) {
        Document document = Jsoup.parse(html);
        return new String[3];
    }
}
