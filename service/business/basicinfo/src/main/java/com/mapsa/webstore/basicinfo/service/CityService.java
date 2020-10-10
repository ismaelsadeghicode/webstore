package com.mapsa.webstore.basicinfo.service;

import com.mapsa.webstore.basicinfo.domain.City;
import com.mapsa.webstore.basicinfo.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CityService {
    private final CityRepository cityRepository;


    public List<City> showAllCity() {
        return cityRepository.findAll();
    }

    public City showAllCity(Long id) throws Exception {
        return cityRepository.findById(id).orElseThrow(() -> new Exception("not find"));
    }

    public void create(City city) {
        City city1 = cityRepository.findById(city.getId()).orElse(null);
        if (city1 == null) {
            cityRepository.save(city);
        }
    }

    public void patch(City city) throws Exception {
        City city1 = cityRepository.findById(city.getId()).orElseThrow(()->new Exception("not find"));
        checkNull(city, city1);
        cityRepository.save(city1);
    }

    public void update(City city) {
        cityRepository.save(city);
    }

    public void delete(City city) {
        cityRepository.delete(city);
    }

    private City checkNull(City cityOne, City cityTwo) {
        if (cityOne.getCode() != null) {
            cityTwo.setCode(cityOne.getCode());
        }
        if (cityOne.getName() != null) {
            cityTwo.setName(cityOne.getName());
        }
        if (cityOne.getProvinceByProvinceId() != null) {
            cityTwo.setProvinceByProvinceId(cityOne.getProvinceByProvinceId());
        }
        if (cityOne.getRemarks() != null) {
            cityTwo.setRemarks(cityOne.getRemarks());
        }
        return cityTwo;
    }


}
