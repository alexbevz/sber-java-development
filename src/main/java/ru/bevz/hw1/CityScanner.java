package ru.bevz.hw1;

import java.io.IOException;
import java.util.List;

public interface CityScanner {

    List<City> scanCityList() throws IOException;
}
