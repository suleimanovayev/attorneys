package attorneys.sites;

import attorneys.sites.gflegal.constant.GflegalConstants;
import attorneys.sites.hellsell.HellSellAttorneyParser;
import attorneys.sites.hellsell.HellSellScrapperService;
import attorneys.sites.hellsell.constant.HellSellConstants;
import attorneys.sites.model.Attorney;
import attorneys.sites.thread.SitesRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    private static List<String> urls = Arrays.asList(
            GflegalConstants.GFLEGAL_URL,
            HellSellConstants.HELL_SELL_URL
    );

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        HellSellScrapperService hell = new HellSellScrapperService();
//        List<String> links = hell.findAllAttorneysLinks(HellSellConstants.HELL_SELL_URL);
//        HellSellAttorneyParser sell = new HellSellAttorneyParser();
//
//        for (String link : links) {
//            String html = HtmlConverter.getHtmlPage(link);
//            System.out.println(sell.resolveName(html));
//            System.out.println(sell.resolveTitle(html));
//            System.out.println(sell.resolvePhone(html));
//            System.out.println(sell.resolveEmail(html));
//            System.out.println(sell.resolveEducation(html));
//            System.out.println(sell.resolveLocation(html));
//            System.out.println(sell.resolveBiography(html));
//            System.out.println(sell.resolveFullBiography(html));
//            System.out.println(Arrays.toString(sell.resolvePracticeArea(html)));
//            System.out.println(sell.resolveBarAdmissions(html));
//            System.out.println();
//        }

        new SitesRunner().runSites();
    }
}
