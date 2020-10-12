package com.mapsa.webstore.basicinfo.controller;

import com.mapsa.webstore.basicinfo.domain.City;
import com.mapsa.webstore.basicinfo.service.CityService;
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
@RequestMapping("City")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CityController {
    private final CityService cityService;

    @GetMapping
    @Timed(value = "basicinfo.city",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.city.get")
    public ResponseEntity<List<City>> showAllCity() {
        return ResponseEntity.ok(cityService.showAllCity());
    }

    @GetMapping("/{id}")
    @Timed(value = "basicinfo.city",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.city.get")
    public ResponseEntity<City> showById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(cityService.showAllCity(id));
    }

    @PostMapping
    @Timed(value = "basicinfo.city",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.city.post")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody City city) {
        cityService.create(city);
    }

    @DeleteMapping
    @Timed(value = "basicinfo.city",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.city.delete")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@RequestBody City city) {
        cityService.delete(city);
    }

    @PutMapping
    @Timed(value = "basicinfo.city",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.city.put")
    @ResponseStatus(code = HttpStatus.OK)
    public void updateOrSave(@RequestBody City city) {
        cityService.update(city);
    }

    @PatchMapping
    @Timed(value = "basicinfo.city",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.city.patch")
    @ResponseStatus(code = HttpStatus.OK)
    public void patch(@RequestBody City city) throws Exception {
        cityService.patch(city);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Timed(value = "basicinfo.city",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.city.exceptions")
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
    @Timed(value = "basicinfo.city",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.city.options")
    public ResponseEntity<?> options()
    {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET,HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.PATCH, HttpMethod.OPTIONS)
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Timed(value = "basicinfo.city",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.city.bad_request")
    @ExceptionHandler(Exception.class)
    public String Exceptions(
            Exception ex) {

        return ex.getMessage();
    }

}
