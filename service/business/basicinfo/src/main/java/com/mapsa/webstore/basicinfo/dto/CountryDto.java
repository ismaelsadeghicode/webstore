package com.mapsa.webstore.basicinfo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CountryDto {
    //"Country","Alpha-2 code","Alpha-3 code","Numeric code""
    private String countryName;
    private String alphabet2Code ;
    private String alphabet3Code ;
    private String numericCode;


}
