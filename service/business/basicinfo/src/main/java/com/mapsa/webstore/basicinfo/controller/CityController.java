package com.mapsa.webstore.basicinfo.controller;

import com.mapsa.webstore.basicinfo.domain.City;
import com.mapsa.webstore.basicinfo.domain.Location;
import com.mapsa.webstore.basicinfo.service.CityService;
import com.mapsa.webstore.basicinfo.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("City")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CityController {
    private final CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> showAllCity() {
        return ResponseEntity.ok(cityService.showAllCity());
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> showById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(cityService.showAllCity(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(City city) {
        cityService.create(city);
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(City city) {
        cityService.delete(city);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void updateOrSave(City city) {
        cityService.update(city);
    }

    @PatchMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void patch(City city) {
        cityService.patch(city);
    }


}
