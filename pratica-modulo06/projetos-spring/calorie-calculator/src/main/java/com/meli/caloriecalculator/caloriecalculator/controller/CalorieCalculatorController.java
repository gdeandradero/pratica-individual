package com.meli.caloriecalculator.caloriecalculator.controller;

import com.meli.caloriecalculator.caloriecalculator.models.IngredientDTO;
import com.meli.caloriecalculator.caloriecalculator.models.PlateDTO;
import com.meli.caloriecalculator.caloriecalculator.service.CalorieCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/plate")
public class CalorieCalculatorController {

    @Autowired
    CalorieCalculatorService calorieCalculatorService;

    @PostMapping("/get-total-calories")
    public ResponseEntity<Double> getTotalCalories(@RequestBody PlateDTO plateDTO){
        return new ResponseEntity<Double>(calorieCalculatorService.getTotalCalories(plateDTO), HttpStatus.OK);
    }

    @PostMapping("/get-ingredients-calories")
    public ResponseEntity<Map<String, Long>> getIngredientsCalories(@RequestBody PlateDTO plateDTO){
        return new ResponseEntity<Map<String, Long>>(calorieCalculatorService
                .getIngredientsCalories(plateDTO), HttpStatus.OK);
    }

    @PostMapping("/get-most-caloric-ingredient")
    public ResponseEntity<IngredientDTO> getMostCaloricIngredient(@RequestBody PlateDTO plateDTO){
        return new ResponseEntity<>(calorieCalculatorService.getMostCaloricIngredient(plateDTO), HttpStatus.OK);
    }

}
