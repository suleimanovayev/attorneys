package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupPracticeAreaParser {
    private static final String PRACTICE_AREA = "ul.fl-list.list-level-1 >li";

    public static String[] resolvePracticeArea(String html) {
        Document document = Jsoup.parse(html);
        Elements areas = document.select(PRACTICE_AREA);
        return areas.stream().map(Element::text).toArray(String[]::new);
    }
}
