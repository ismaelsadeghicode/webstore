package com.mapsa.webstore.basicinfo.service;

import com.mapsa.webstore.basicinfo.domain.Country;
import com.mapsa.webstore.basicinfo.repository.CoutryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ =@Autowired)
public class CountryService {

    private final CoutryRepository coutryRepository;

    public List<Country> showAllCountry() {
        return coutryRepository.findAll();
    }

    public Country showAllCountry(Long id) throws Exception {
        return coutryRepository.findById(id).orElseThrow(() -> new Exception("not find"));
    }

    public void create(Country country) {
        Country country1 = coutryRepository.findById(country.getId()).orElse(null);
        if (country1 == null) {
            coutryRepository.save(country);
        }
    }
    public void update(Country country) {
        coutryRepository.save(country);
    }

    public void delete(Country country) {
        coutryRepository.delete(country);
    }

//    public void patch(Country country) {
//        Country country1 = coutryRepository.findById(country.getId()).orElse(new Country());
//        checkNull(country, country1);
//        coutryRepository.save(country1);
//    }



//    private Location checkNull(Country countryOne, Country countryTwo) {
//
//        return countryTwo;
//    }
}
