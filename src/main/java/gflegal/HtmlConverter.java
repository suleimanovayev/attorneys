package gflegal;

import org.jsoup.Jsoup;

import java.io.IOException;

public class HtmlConverter {

    public static String getHtmlPage(String link) {
        try {
            return Jsoup.connect(link).get().html();
        } catch (IOException e) {
            System.out.printf("log4j");
        }
        return null;
    }
}
