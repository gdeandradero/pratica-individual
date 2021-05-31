package com.meli.starwars.starwars.controller;

import com.meli.starwars.starwars.service.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/star-wars")
public class StarWarsController {

    @Autowired
    StarWarsService starWarsService;

    @GetMapping("/{name}")
    public ResponseEntity<List<String>> getNameWithParam(@PathVariable String name){
        return new ResponseEntity<>(starWarsService.getNamesWithParam(name), HttpStatus.OK);
    }

}
