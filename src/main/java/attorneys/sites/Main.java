package attorneys.sites;

import attorneys.sites.gflegal.constant.GflegalConstants;
import attorneys.sites.hellsell.constant.HellSellConstants;
import attorneys.sites.thread.SitesRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    private static List<String> urls = Arrays.asList(
            GflegalConstants.GFLEGAL_URL,
            HellSellConstants.HELL_SELL_URL
    );

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new SitesRunner().runSites();
    }
}
