package com.mapsa.webstore.basicinfo.controller;

import com.mapsa.webstore.basicinfo.domain.Location;
import com.mapsa.webstore.basicinfo.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("location")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class LocationController {
    private final LocationService locationService;

    @GetMapping
    public ResponseEntity<List<Location>> showAllLocation() {
        return ResponseEntity.ok(locationService.showAllLocation());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> showById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(locationService.showAllLocation(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(Location location) {
        locationService.create(location);
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(Location location) {
        locationService.delete(location);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void updateOrSave(Location location) {
        locationService.update(location);
    }

    @PatchMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void patch(Location location) {
        locationService.patch(location);
    }


}
