package gflegal;

import gflegal.parser.JsoupParserHelper;
import gflegal.parser.JsoupTitleParser;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = args[0];
        Document document = JsoupLoader.getPage(url);
        JsoupScraper scraper = new JsoupScraper();
       List<String> allAttorneyLinks = scraper.findAttorneysLinks(document);

        for (String link : allAttorneyLinks) {
            String html = HtmlConverter.getHtmlPage(link);
            System.out.printf(JsoupTitleParser.resolveTitle(html));
        }
    }
}
