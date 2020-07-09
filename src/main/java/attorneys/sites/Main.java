package attorneys.sites;

import attorneys.sites.kaplanrice.KaplanriceAttorneyParser;
import attorneys.sites.kaplanrice.KaplanriceScraperService;
import attorneys.sites.kmcllaw.KmcllawAttorneyParser;
import attorneys.sites.kmcllaw.KmcllawScraperService;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        new SitesRunner().runSites();

        KaplanriceAttorneyParser sell = new KaplanriceAttorneyParser();
        KaplanriceScraperService service = new KaplanriceScraperService(sell);
        List<String> links = service.findAllAttorneysLinks("http://www.kaplanrice.com/lawyers.html");

        for (String link : links) {
            String html = HtmlConverter.getHtmlPage(link);
            System.out.println(sell.resolveName(html));
            System.out.println(sell.resolveTitle(html));
            System.out.println(sell.resolvePhone(html));
//            System.out.println(sell.resolveEmail(html));
//            System.out.println(sell.resolveEducation(html));
//            System.out.println(sell.resolveLocation(html));
//            System.out.println(sell.resolveBiography(html));
//            System.out.println(sell.resolveFullBiography(html));
//            System.out.println(Arrays.toString(sell.resolvePracticeArea(html)));
//            System.out.println(sell.resolveBarAdmissions(html));
            System.out.println();
        }
//        try {
//            String a = Jsoup.connect("https://www.kmcllaw.com/attorney/jacqueline-o-eisermann/").get().html();
//            System.out.println(a);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
