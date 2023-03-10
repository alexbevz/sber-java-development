package ru.bevz;

import ru.bevz.hw1.City;
import ru.bevz.hw1.CityCsvScanner;
import ru.bevz.hw1.CityScanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        runHw1Part5();
    }

    private static void runHw1Part5() {
        List<City> cityList = prepareAndGetCityList();

        List<City> cityListSortedByName = new ArrayList<>(cityList);
        cityListSortedByName.sort(Comparator.comparing(City::getName));
        cityListSortedByName.forEach(System.out::println);

        List<City> cityListSortedByRegionAndName = new ArrayList<>(cityList);
        cityListSortedByRegionAndName.sort(
                Comparator.comparing(City::getRegion)
                        .thenComparing(City::getRegion)
        );
        cityListSortedByRegionAndName.forEach(System.out::println);
    }

    private static void runHw1Part3() {
        List<City> cityList = prepareAndGetCityList();

        cityList.forEach(System.out::println);
    }

    private static List<City> prepareAndGetCityList() {
        CityScanner cityScanner = new CityCsvScanner();
        try {
            return cityScanner.scanCityList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}