package attorneys.sites;

import attorneys.sites.kutakrock.KutakRockAttorneyParser;
import attorneys.sites.kutakrock.KutakRockScraperService;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException, ParseException {
//        new SitesRunner().runSites();

        KutakRockAttorneyParser sell = new KutakRockAttorneyParser();
        KutakRockScraperService service = new KutakRockScraperService(sell);
        List<String> links = service.findAllAttorneysLinks("https://www.kutakrock.com/");
        SeleniumService.loadDriver();

        for (String link : links) {
            String html = HtmlConverter.getHtmlPage(link);
//            System.out.println(sell.resolveName(html));
//            System.out.println(sell.resolveTitle(html));
//            System.out.println(sell.resolvePhone(html));
//            System.out.println(sell.resolveEmail(html));
//            System.out.println(sell.resolveEducation(html));
            System.out.println(sell.resolveLocation(link));
//            System.out.println(sell.resolveBiography(html));
//            System.out.println(sell.resolveFullBiography(html));
//            System.out.println(sell.resolvePracticeArea(html));
//            System.out.println(sell.resolveBarAdmissions(html));
            System.out.println();
//        try {
//            String a = Jsoup.connect("https://www.kmcllaw.com/attorney/jacqueline-o-eisermann/").get().html();
//            System.out.println(a);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
        }
    }
}

