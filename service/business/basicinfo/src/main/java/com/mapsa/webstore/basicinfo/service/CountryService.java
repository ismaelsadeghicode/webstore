package com.mapsa.webstore.basicinfo.service;

import com.mapsa.webstore.basicinfo.domain.Country;
import com.mapsa.webstore.basicinfo.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ =@Autowired)
public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> showAllCountry() {
        return countryRepository.findAll();
    }

    public Country showAllCountry(Long id) throws Exception {
        return countryRepository.findById(id).orElseThrow(() -> new Exception("not find"));
    }

    public void create(Country country) {
        Country country1 = countryRepository.findById(country.getId()).orElse(null);
        if (country1 == null) {
            countryRepository.save(country);
        }
    }
    public void update(Country country) {
        countryRepository.save(country);
    }

    public void delete(Country country) {
        countryRepository.delete(country);
    }


}
