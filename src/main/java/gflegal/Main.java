package gflegal;

import gflegal.model.Attorney;
import gflegal.parser.JsoupEducationParser;
import gflegal.parser.JsoupRawEducationParser;
import gflegal.parser.helper.JsoupParserHelper;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = args[0];
        Document document = JsoupLoader.getPage(url);
        JsoupScraper jsoupScraper = new JsoupScraper();
        List<String> allAttorneyLinks = jsoupScraper.findAttorneysLinks(document);
        List<Attorney> allAttorneyList = new JsoupParserHelper().parseAllLinks(allAttorneyLinks);
        DataDisplay.displayOnConsole(allAttorneyList);

//        String html = HtmlConverter.getHtmlPage("https://www.gflegal.com/Attorneys/Britta-Thornquist.html");
//        System.out.println(JsoupRawEducationParser.resolveRawEducation(html));
//        System.out.println(JsoupEducationParser.resolveEmptyEducation(html));
//        System.out.println(JsoupEducationParser.resolveEducation(html));

    }
}
