package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupTitleParser {

    public static String resolveTitle(String html) {
        Document doc = Jsoup.parse(html);
       return doc.select("div#containerPageTitle >h1").text();
    }
}
