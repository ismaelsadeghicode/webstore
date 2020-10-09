package com.mapsa.webstore.basicinfo.controller;

import com.mapsa.webstore.basicinfo.domain.Country;
import com.mapsa.webstore.basicinfo.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Counrty")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CounrtyController {
    private final CountryService countryService;

    @GetMapping
    public ResponseEntity<List<Country>> showAllCity() {
        return ResponseEntity.ok(countryService.showAllCountry());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> showById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(countryService.showAllCountry(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(Country country) {
        countryService.create(country);
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(Country country) {
        countryService.delete(country);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void updateOrSave(Country country) {
        countryService.update(country);
    }

//    @PatchMapping
//    @ResponseStatus(code = HttpStatus.OK)
//    public void patch(City city) {
//
//    }

}
