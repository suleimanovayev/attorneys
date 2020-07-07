package test;

import gflegal.HtmlConverter;
import gflegal.JsoupLoader;
import gflegal.JsoupScraper;
import gflegal.parser.JsoupTitleParser;
import junit.framework.Assert;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AttorneysTest {
    private static final String MAIN_PAGE = "http://www.gflegal.com/Attorneys/";
    private List<String> firstTenAttorneys = Arrays.asList(
            "https://www.gflegal.com/Attorneys/Marc-J-Becker.html",
            "https://www.gflegal.com/Attorneys/Michael-Bollag.html",
            "https://www.gflegal.com/Attorneys/Ronald-E-Burton.html",
            "https://www.gflegal.com/Attorneys/Joseph-W-Chouinard.html",
            "https://www.gflegal.com/Attorneys/Bindi-Dharia.html",
            "https://www.gflegal.com/Attorneys/Steven-M-Fenton.html",
            "https://www.gflegal.com/Attorneys/Douglas-H-Gladstone.html",
            "https://www.gflegal.com/Attorneys/Raphael-Katz.html",
            "https://www.gflegal.com/Attorneys/Jenny-Kim.html",
            "https://www.gflegal.com/Attorneys/Soyoung-Lee.html");
   private static int quantity = 52;

    @Test
    public void getFirstTenLinksOfAttorneys() { Document document = JsoupLoader.getPage(MAIN_PAGE);
        List<String> attorneysUrl = JsoupScraper.findAttorneysLinks(document);
        List<String> actual = attorneysUrl.stream().limit(10).collect(Collectors.toList());
        Assert.assertEquals(firstTenAttorneys, actual);
    }

    @Test
    public void titleNotNull() {
        List<String> titles = firstTenAttorneys.stream().map(link -> {
            String html = HtmlConverter.getHtmlPage(link);
            return JsoupTitleParser.resolveTitle(html);
        }).collect(Collectors.toList());
        Assert.assertNotNull(titles);
    }

    @Test
    public void checkQuantityOfAttorney() {
        Document document = JsoupLoader.getPage(MAIN_PAGE);
        List<String> attorneysUrl = JsoupScraper.findAttorneysLinks(document);
        Assert.assertEquals(52, attorneysUrl.size());
    }
}
