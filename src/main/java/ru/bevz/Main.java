package ru.bevz;

import ru.bevz.hw1.City;
import ru.bevz.hw1.CityCsvScanner;
import ru.bevz.hw1.CityScanner;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        runHw1Part9();
    }

    private static void runHw1Part9() {
        List<City> cityList = prepareAndGetCityList();

        cityList.stream()
                .collect(Collectors.groupingBy(City::getRegion, Collectors.counting()))
                .forEach((region, count) -> System.out.printf("%s - %d%n", region, count));
    }

    private static void runHw1Part7() {
        List<City> cityList = prepareAndGetCityList();

        final int cityListSize = cityList.size();

        if (cityListSize == 0) {
            throw new IllegalArgumentException();
        }

        int cityWithMaxPopulationIndex = 0;
        City cityWithMaxPopulation = cityList.get(cityWithMaxPopulationIndex);

        for (int i = 1; i < cityListSize; i++) {
            City currentCity = cityList.get(i);
            if (cityWithMaxPopulation.getPopulation().compareTo(currentCity.getPopulation()) < 0) {
                cityWithMaxPopulation = currentCity;
                cityWithMaxPopulationIndex = i;
            }
        }

        Integer maxPopulation = cityWithMaxPopulation.getPopulation();

        System.out.printf(
                "[%d] = %s%n",
                cityWithMaxPopulationIndex,
                new DecimalFormat("###,###").format(maxPopulation)
        );

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