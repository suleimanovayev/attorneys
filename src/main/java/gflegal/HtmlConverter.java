package gflegal;

import com.sun.istack.internal.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;

import java.io.IOException;

public class HtmlConverter {
    private static Logger logger = Logger.getLogger(HtmlConverter.class);

    public static String getHtmlPage(String link) {
        try {
            return Jsoup.connect(link).get().html();
        } catch (IOException e) {
            logger.warning("Cannot connect to url");
        }
        return null;
    }
}
