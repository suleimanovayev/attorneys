package attorneys.sites;

import org.jsoup.Jsoup;

import java.io.IOException;

public class HtmlConverter {

    public static String getHtmlPageFromJsoup(String link) {
        try {
            return Jsoup.connect(link).get().html();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static String getJsoupPageFromSelenium(String link) {
//
//    }

}
