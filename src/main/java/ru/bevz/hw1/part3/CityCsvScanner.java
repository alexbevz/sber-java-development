package ru.bevz.hw1.part3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CityCsvScanner implements CityScanner {

    @Override
    public List<City> scanCityList() throws IOException {
        List<City> cityList = new ArrayList<>();

        URL dataPath = getClass()
                .getClassLoader()
                .getResource(Constant.DATA_PATH);

        File file = new File(dataPath.getPath());
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        while (reader.ready()) {
            String line = reader.readLine();
            City city = convertStringLineToCity(Constant.CSV_SEPARATOR, line);
            cityList.add(city);
        }

        return cityList;
    }

    private City convertStringLineToCity(String separator, String line) {
        String[] splitResult = line.split(separator);
        System.out.println(splitResult.length);
        System.out.println(line);

        String cityName = splitResult[1];
        String cityRegion = splitResult[2];
        String cityDistrict = splitResult[3];
        Integer cityPopulation = Integer.parseInt(splitResult[4]);
        String cityFoundation = splitResult.length > 5 ? splitResult[5] : "";

        return City.builder()
                .name(cityName)
                .region(cityRegion)
                .district(cityDistrict)
                .population(cityPopulation)
                .foundation(cityFoundation)
                .build();
    }
}
