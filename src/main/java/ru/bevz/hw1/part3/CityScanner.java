package ru.bevz.hw1.part3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface CityScanner {

    List<City> scanCityList() throws IOException;
}
