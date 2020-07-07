package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupBiographyParser {
    private static final String BIOGRAPHY = "div.attorneyProfileNarrative p:contains(Education:) +ul+p";

    public static String resolveBiography(String html) {
        Document document = Jsoup.parse(html);
        return document.select(BIOGRAPHY).text();
    }
}
