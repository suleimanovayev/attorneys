package attorneys.sites;

import attorneys.sites.thread.SitesRunner;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new SitesRunner().runSites();
    }
}
