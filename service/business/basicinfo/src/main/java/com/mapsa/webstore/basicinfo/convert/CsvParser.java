package com.mapsa.webstore.basicinfo.convert;

import com.mapsa.webstore.basicinfo.domain.Country;
import com.mapsa.webstore.basicinfo.dto.CountryDto;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class CsvParser<T> {
    public List<Country> Csv(String url) {
        String csvFile = url;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<Country> countrys = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                countrys.add(new
                        Country().setName(country[0]).setAlphabet2Code(country[1]).setAlphabet3Code(country[2]).setNumericCode(country[3]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return countrys;
    }
}

