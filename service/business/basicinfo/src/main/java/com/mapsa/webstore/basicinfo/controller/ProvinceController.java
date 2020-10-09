package com.mapsa.webstore.basicinfo.controller;

import com.mapsa.webstore.basicinfo.domain.Province;
import com.mapsa.webstore.basicinfo.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Province")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProvinceController {

    private final ProvinceService provinceService;

    @GetMapping
    public ResponseEntity<List<Province>> showAllLocation() {
        return ResponseEntity.ok(provinceService.showAllProvince());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Province> showById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(provinceService.showAllProvince(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(Province province) {
        provinceService.create(province);
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(Province province) {
        provinceService.delete(province);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void updateOrSave(Province province) {
        provinceService.update(province);
    }


}
