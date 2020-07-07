package gflegal;

import com.sun.istack.internal.logging.Logger;
import lombok.extern.log4j.Log4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupLoader {
    private static Logger logger = Logger.getLogger(JsoupLoader.class);

    public static Document getPage(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            logger.warning("Cannot connect to url");
        }
        return null;
    }
}
