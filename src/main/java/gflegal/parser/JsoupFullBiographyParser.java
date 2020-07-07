package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupFullBiographyParser {
    private static final String BIOGRAPHY = ".attorneyProfileNarrative p:has(:not(strong))";
    private static final String BIOGRAPHY_SECOND_PARAGRAPH = ".attorneyProfileNarrative p:gt(2)";
    private static final String BIOGRAPHY_THIRD_PARAGRAPH = ".attorneyProfileNarrative p";

    public static String resolveFullBiography(String html) {
        StringBuilder builder = new StringBuilder();
        Document document = Jsoup.parse(html);
        return builder.append(document.select(BIOGRAPHY).text())
                .append(document.select(BIOGRAPHY_SECOND_PARAGRAPH).text())
                .append(document.select(BIOGRAPHY_THIRD_PARAGRAPH).text()).toString();
    }
}
