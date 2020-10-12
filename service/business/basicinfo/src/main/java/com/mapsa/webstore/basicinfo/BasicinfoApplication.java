package com.mapsa.webstore.basicinfo;

import com.mapsa.webstore.basicinfo.convert.CsvParser;
import com.mapsa.webstore.basicinfo.domain.Country;
import com.mapsa.webstore.basicinfo.dto.CountryDto;
import com.mapsa.webstore.basicinfo.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.List;

@SpringBootApplication
//@EnableDiscoveryClient
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BasicinfoApplication implements CommandLineRunner {

    private final CountryRepository countryRepository;
    public static void main(String[] args)  {
        SpringApplication.run(BasicinfoApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        try{
        CsvParser<CountryDto> parser =  new CsvParser();
       List<Country> countries =parser.Csv("C:/countries_codes_and_coordinates.csv");
            countryRepository.saveAll(countries);
        }catch (Exception ex){
            System.out.println("not find");
        }
    }
}
