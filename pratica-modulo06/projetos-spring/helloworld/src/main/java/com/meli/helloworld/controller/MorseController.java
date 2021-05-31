package com.meli.helloworld.controller;

import com.meli.helloworld.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @Autowired
    MorseService morseService;

    @GetMapping("/morse/{morseCode}")
    public ResponseEntity<?> translateMorseCode(@PathVariable String morseCode){
        return ResponseEntity.ok(morseService.translateMorseCode(morseCode));
    }

}
