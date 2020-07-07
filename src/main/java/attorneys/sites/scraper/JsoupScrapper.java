package attorneys.sites.scraper;

import org.jsoup.nodes.Document;

import java.util.List;

public abstract class JsoupScrapper {

    abstract List<String> findAllAttorneysLinks(Document document);
}
