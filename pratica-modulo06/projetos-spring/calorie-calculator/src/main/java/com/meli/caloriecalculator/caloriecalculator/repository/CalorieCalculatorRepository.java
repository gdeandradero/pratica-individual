package com.meli.caloriecalculator.caloriecalculator.repository;

import com.meli.caloriecalculator.caloriecalculator.models.IngredientDTO;
import com.meli.caloriecalculator.caloriecalculator.models.PlateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Repository
public interface CalorieCalculatorRepository {
    Double getTotalCalories(PlateDTO plateDTO);
    Map<String, Long> getIngredientsCalories(PlateDTO plateDTO);
    IngredientDTO getMostCaloricIngredient(PlateDTO plateDTO);
}
