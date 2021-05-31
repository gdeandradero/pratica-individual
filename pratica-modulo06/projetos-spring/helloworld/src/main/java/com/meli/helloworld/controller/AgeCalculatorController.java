package com.meli.helloworld.controller;

import com.meli.helloworld.service.CalculatorService;
import com.meli.helloworld.service.CalculatorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/age")
public class AgeCalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<?> doCalc(@PathVariable Integer year,
                                    @PathVariable Integer month,
                                    @PathVariable Integer day){
        return ResponseEntity.ok(calculatorService.convertDateToAge(year, month, day));
    }

}
