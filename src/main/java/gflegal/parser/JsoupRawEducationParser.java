package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupRawEducationParser {
    private static final String RAW_EDUCATION = ".attorneyProfileNarrative p:has(strong:contains(Education:)) + ul li";

    public static String[] resolveRawEducation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(RAW_EDUCATION)
                .text().split(" ");
    }
}
