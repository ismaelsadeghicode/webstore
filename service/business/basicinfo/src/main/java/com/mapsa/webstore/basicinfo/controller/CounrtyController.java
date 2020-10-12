package com.mapsa.webstore.basicinfo.controller;

import com.mapsa.webstore.basicinfo.domain.Country;
import com.mapsa.webstore.basicinfo.service.CountryService;
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
@RequestMapping("Counrty")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CounrtyController {
    private final CountryService countryService;

    @GetMapping
    @Timed(value = "basicinfo.Counrty",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.Counrty.get")
    public ResponseEntity<List<Country>> showAllCounrty() {
        return ResponseEntity.ok(countryService.showAllCountry());
    }

    @GetMapping("/{id}")
    @Timed(value = "basicinfo.Counrty",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.Counrty.get")
    public ResponseEntity<Country> showById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(countryService.showAllCountry(id));
    }

    @PostMapping
    @Timed(value = "basicinfo.Counrty",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.Counrty.post")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody Country country) {
        countryService.create(country);
    }

    @DeleteMapping
    @Timed(value = "basicinfo.Counrty",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.Counrty.delete")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@RequestBody Country country) {
        countryService.delete(country);
    }

    @PutMapping
    @Timed(value = "basicinfo.Counrty",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.Counrty.put")
    @ResponseStatus(code = HttpStatus.OK)
    public void updateOrSave(@RequestBody Country country) {
        countryService.update(country);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Timed(value = "basicinfo.Counrty",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.Counrty.Exceptions")
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
    @Timed(value = "basicinfo.Counrty",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.Counrty.options")
    public ResponseEntity<?> options()
    {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET,HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.OPTIONS)
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Timed(value = "basicinfo.Counrty",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99},description = "This.is.test.Counrty.bad_request")
    @ExceptionHandler(Exception.class)
    public String Exceptions(
            Exception ex) {

        return ex.getMessage();
    }

}
