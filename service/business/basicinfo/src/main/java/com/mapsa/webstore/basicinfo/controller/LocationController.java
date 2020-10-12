package com.mapsa.webstore.basicinfo.controller;

import com.mapsa.webstore.basicinfo.domain.Location;
import com.mapsa.webstore.basicinfo.service.LocationService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("location")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class LocationController {
    private final LocationService locationService;

    @GetMapping
    @Timed(value = "basicinfo.location",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.location.get")
    public ResponseEntity<List<Location>> showAllLocation() {
        return ResponseEntity.ok(locationService.showAllLocation());
    }

    @GetMapping("/{id}")
    @Timed(value = "basicinfo.location",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.location.get")
    public ResponseEntity<Location> showById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(locationService.showAllLocation(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Timed(value = "basicinfo.location",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.location.post")
    public void create(@RequestBody Location location) {
        locationService.create(location);
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Timed(value = "basicinfo.location",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.location.delete")
    public void delete(@RequestBody Location location) {
        locationService.delete(location);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Timed(value = "basicinfo.location",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.location.put")
    public void updateOrSave(@RequestBody Location location) {
        locationService.update(location);
    }

    @PatchMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Timed(value = "basicinfo.location",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.location.patch")
    public void patch(@RequestBody Location location) throws Exception {
        locationService.patch(location);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Timed(value = "basicinfo.location",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.location.exception")
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    @Timed(value = "basicinfo.location",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.location.options")
    public ResponseEntity<?> options()
    {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET,HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PUT,HttpMethod.PATCH, HttpMethod.OPTIONS)
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Timed(value = "basicinfo.location",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.location.bad_request")
    @ExceptionHandler(Exception.class)
    public String Exceptions(
            Exception ex) {

        return ex.getMessage();
    }
}
