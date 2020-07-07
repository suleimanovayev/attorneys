package gflegal.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupBarAdmissionParser {

    public static String[] resolveBarAdmissions(String html) {
        Document document = Jsoup.parse(html);
        return new String[3];
    }

}
