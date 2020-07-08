package attorneys.sites;

import attorneys.sites.gflegal.constant.GflegalConstants;
import attorneys.sites.hellsell.constant.HellSellConstants;
import attorneys.sites.thread.SitesRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new SitesRunner().runSites();
    }
}
