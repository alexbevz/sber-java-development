package ru.bevz;

import ru.bevz.hw1.part3.City;
import ru.bevz.hw1.part3.CityCsvScanner;
import ru.bevz.hw1.part3.CityScanner;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        runHw1Part3();

    }

    private static void runHw1Part3() {
        CityScanner cityScanner = new CityCsvScanner();

        List<City> cityList;

        try {
            cityList = cityScanner.scanCityList();
            cityList.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}