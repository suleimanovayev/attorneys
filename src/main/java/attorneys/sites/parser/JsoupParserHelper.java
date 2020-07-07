//package attorneys.sites.parser;
//
//import attorneys.sites.HtmlConverter;
//import attorneys.sites.model.Attorney;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class JsoupParserHelper {
//
//    public List<Attorney> loadLawyers(List<String> allAttorneyLinks) {
//        List<Attorney> allAttorneys = new ArrayList<>();
//        for (String link : allAttorneyLinks) {
//            String html = HtmlConverter.getHtmlPage(link);
//            Attorney attorney = new JsoupParserAttorney().parseAttorney(html);
//            allAttorneys.add(attorney);
//        }
//        return allAttorneys;
//    }
//}
