package com.mapsa.webstore.basicinfo.service;

import com.mapsa.webstore.basicinfo.domain.Province;
import com.mapsa.webstore.basicinfo.repository.ProvinceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ =@Autowired)
public class ProvinceService {
    private final ProvinceRepository provinceRepository;

    public List<Province> showAllProvince() {
        return provinceRepository.findAll();
    }

    public Province showAllProvince(Long id) throws Exception {
        return provinceRepository.findById(id).orElseThrow(() -> new Exception("not find"));
    }

    public void create(Province province) {
        Province province1 = provinceRepository.findById(province.getId()).orElse(null);
        if (province1 == null) {
            provinceRepository.save(province);
        }
    }
    public void update(Province province) {
        provinceRepository.save(province);
    }

    public void delete(Province province) {
        provinceRepository.delete(province);
    }

}
