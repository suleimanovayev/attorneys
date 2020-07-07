package gflegal.parser.helper;

import gflegal.HtmlConverter;
import gflegal.model.Attorney;
import gflegal.parser.helper.JsoupParserAttorney;

import java.util.ArrayList;
import java.util.List;

public class JsoupParserHelper {

    public List<Attorney> parseAllLinks(List<String> allAttorneyLinks) {
        List<Attorney> allAttorneys = new ArrayList<>();
        for (String link : allAttorneyLinks) {
            String html = HtmlConverter.getHtmlPage(link);
            Attorney attorney = JsoupParserAttorney.parseAttorney(html);
            allAttorneys.add(attorney);
        }
        return allAttorneys;
    }
}
