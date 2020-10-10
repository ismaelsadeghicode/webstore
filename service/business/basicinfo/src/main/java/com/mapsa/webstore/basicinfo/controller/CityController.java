package com.mapsa.webstore.basicinfo.controller;

import com.mapsa.webstore.basicinfo.domain.City;
import com.mapsa.webstore.basicinfo.service.CityService;
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
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
    public ResponseEntity<?> options()
    {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET,HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.OPTIONS)
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public String Exceptions(
            Exception ex) {

        return ex.getMessage();
    }
}
