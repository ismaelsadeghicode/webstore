package com.mapsa.webstore.basicinfo.dto;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class LocationDto {

    private Long idCountry;
    private String nameCountry;
    private String numericCodeCountry;
    private String remarksCountry;
    private long lockVersionCountry;
    private Long idProvince;
    private String nameProvince;
    private String codeProvince;
    private String remarksProvince;
    private long lockVersionProvince;
    private Long idCity;
    private String nameCity;
    private String codeCity;
    private String remarksCity;
    private long lockVersionCity;
    private String titleLocation;
    private String addressLocation;
    private String longitudeLocation;
    private String latitudeLocation;
    private String remarksLocation;
    private long lockVersionLocation;
}
