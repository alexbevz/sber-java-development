package ru.bevz.hw1;

import lombok.*;

@Data
@Builder
@ToString
public class City {

    private String name;

    private String region;

    private String district;

    private Integer population;

    // TODO: изменить на LocalDate
    private String foundation;

}
