package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupEducationParser {
    private static final String EDUCATION = ".attorneyProfileNarrative p:has(strong:contains(Education:)) + ul li";
    private static final String EMPTY_EDUCATION = "div.attorneyProfileNarrative, strong:contains(Education:) + ul li";

    public static String resolveEducation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(EDUCATION)
                .text();
    }

    public static String resolveEmptyEducation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(EMPTY_EDUCATION)
                .text();
    }



}
