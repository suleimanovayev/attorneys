package gflegal;

import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = args[0];
        Document document = JsoupLoader.getPage(url);
        JsoupScraper scraper = new JsoupScraper();
       List<String> allAttorneyLinks = scraper.findAttorneysLinks(document);
       allAttorneyLinks.forEach(System.out::println);
    }
}
