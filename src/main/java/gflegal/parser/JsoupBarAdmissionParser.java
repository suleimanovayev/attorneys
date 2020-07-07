package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupBarAdmissionParser {
    private static final String BAR_ADMISSIONS = "div[class^=attorneyProfile] >ul";

    public static String[] resolveBarAdmissions(String html) {
        Document document = Jsoup.parse(html);
        return document.select(BAR_ADMISSIONS)
                .get(0)
                .text().split(" ");
    }
}
