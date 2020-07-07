package gflegal;

import gflegal.model.Attorney;

import java.util.List;

public class DataDisplay {

    public static void displayOnConsole(List<Attorney> allAttorney) {
        allAttorney.forEach(System.out::println);
    }
}
