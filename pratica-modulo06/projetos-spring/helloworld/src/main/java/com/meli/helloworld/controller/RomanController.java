package com.meli.helloworld.controller;

import com.meli.helloworld.service.MorseService;
import com.meli.helloworld.service.RomanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanController {

    @Autowired
    RomanService romanService;

    @GetMapping("/{number}")
    public ResponseEntity<?> getRomanNumber(@PathVariable Integer number){
        return ResponseEntity.ok(romanService.convertToRoman(number));
    }

}
