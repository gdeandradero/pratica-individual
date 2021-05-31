package com.meli.helloworld.controller;

import com.meli.helloworld.models.HouseDTO;
import com.meli.helloworld.service.SquareMeterCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/square-meter-calculator")
public class SquareMeterCalculatorController {

    @Autowired
    SquareMeterCalculatorService squareMeterCalculatorService;

    @PostMapping("/total-house-meter")
    public HouseDTO totalHouseMeter(@RequestBody HouseDTO houseDTO){
        return squareMeterCalculatorService.totalHouseMeter(houseDTO);
    }

    @PostMapping("/house-price")
    public ResponseEntity<?> housePrice(@RequestBody HouseDTO houseDTO){
        System.out.println(houseDTO.getName() + houseDTO.getAdress() + houseDTO.getRoomDTOS());
        return new ResponseEntity<>(squareMeterCalculatorService.housePrice(houseDTO), HttpStatus.OK);
    }

    @PostMapping("/largest-room")
    public ResponseEntity<?> largestRoom(@RequestBody HouseDTO houseDTO){
        return new ResponseEntity<>(squareMeterCalculatorService.largestRoom(houseDTO), HttpStatus.OK);
    }

    @PostMapping("/square-meter-room")
    public ResponseEntity<?> squareMeterRoom(@RequestBody HouseDTO houseDTO){
        return new ResponseEntity<>(squareMeterCalculatorService.squareMeterRoom(houseDTO), HttpStatus.OK);
    }
}
