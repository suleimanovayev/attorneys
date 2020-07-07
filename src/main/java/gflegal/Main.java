package gflegal;

import gflegal.model.Attorney;
import gflegal.parser.*;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = args[0];
        Document document = JsoupLoader.getPage(url);
        JsoupScraper jsoupScraperScraper = new JsoupScraper();
        List<String> allAttorneyLinks = jsoupScraperScraper.findAttorneysLinks(document);
        List<Attorney> allAttorneyList = new JsoupParserHelper().parseAllLinks(allAttorneyLinks);
        DataDisplay.displayOnConsole(allAttorneyList);
    }
}
