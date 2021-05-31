package com.meli.caloriecalculator.caloriecalculator.service;

import com.meli.caloriecalculator.caloriecalculator.models.IngredientDTO;
import com.meli.caloriecalculator.caloriecalculator.models.PlateDTO;
import com.meli.caloriecalculator.caloriecalculator.repository.CalorieCalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CalorieCalculatorServiceImpl implements CalorieCalculatorService {

    @Autowired
    CalorieCalculatorRepository calorieCalculatorRepository;

    @Override
    public Double getTotalCalories(PlateDTO plateDTO) {
        return calorieCalculatorRepository.getTotalCalories(plateDTO);
    }

    @Override
    public Map<String, Long> getIngredientsCalories(PlateDTO plateDTO) {
        return calorieCalculatorRepository.getIngredientsCalories(plateDTO);
    }

    @Override
    public IngredientDTO getMostCaloricIngredient(PlateDTO plateDTO) {
        return calorieCalculatorRepository.getMostCaloricIngredient(plateDTO);
    }
}
