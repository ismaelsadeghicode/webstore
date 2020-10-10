package com.mapsa.webstore.basicinfo.controller;

import com.mapsa.webstore.basicinfo.domain.Province;
import com.mapsa.webstore.basicinfo.service.ProvinceService;
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
