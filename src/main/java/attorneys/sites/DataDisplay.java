package attorneys.sites;

import attorneys.sites.model.Attorney;

import java.util.List;

public class DataDisplay {

    public static void displayOnConsole(List<Attorney> allAttorney) {
        allAttorney.forEach(System.out::println);
    }
}
