package com.meli.caloriecalculator.caloriecalculator.repository;

import com.meli.caloriecalculator.caloriecalculator.models.IngredientDTO;
import com.meli.caloriecalculator.caloriecalculator.models.PlateDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CalorieCalculatorRepositoryImpl implements CalorieCalculatorRepository {

    List<IngredientDTO> ingredientDTOS;

    public CalorieCalculatorRepositoryImpl() {
        ingredientDTOS = findAllIngredients();
    }

    public List<IngredientDTO> findAllIngredients() {
        List<IngredientDTO> ingredientsReturn = new ArrayList<IngredientDTO>();

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/resources/food.json")) {
            JSONArray ingredients = (JSONArray) jsonParser.parse(reader);
            for (Object jsonObject : ingredients) {
                jsonObject = (JSONObject) jsonObject;
                IngredientDTO ingredientDTO = new IngredientDTO();
                ingredientDTO.setName((String) ((JSONObject) jsonObject).get("name"));
                ingredientDTO.setCalories((Long) ((JSONObject) jsonObject).get("calories"));
                ingredientsReturn.add(ingredientDTO);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ingredientsReturn;
    }

    public Long getIngredientCalories(String nameIngredient){
        for (IngredientDTO ingredientDTO : ingredientDTOS){
            if (ingredientDTO.getName().compareTo(nameIngredient) == 0){
                return ingredientDTO.getCalories();
            }
        }
        return 0L;
    }

    @Override
    public Double getTotalCalories(PlateDTO plateDTO) {
        Double sumCalories = 0.0;
        if (plateDTO.getIngredientDTOS() == null){
            return sumCalories;
        }
        for (IngredientDTO ingredientDTO : plateDTO.getIngredientDTOS()){
            sumCalories += ingredientDTO.getPeso() * getIngredientCalories(ingredientDTO.getName());
        }
        return sumCalories;
    }

    @Override
    public Map<String, Long> getIngredientsCalories(PlateDTO plateDTO) {
        Map<String, Long> mapReturn = new HashMap<>();
        if (plateDTO.getIngredientDTOS() == null){
            return mapReturn;
        }
        for (IngredientDTO ingredientDTO : plateDTO.getIngredientDTOS()){
            mapReturn.put(ingredientDTO.getName(), getIngredientCalories(ingredientDTO.getName()));
        }
        return mapReturn;
    }

    @Override
    public IngredientDTO getMostCaloricIngredient(PlateDTO plateDTO) {
        if (plateDTO.getIngredientDTOS() == null){
            return new IngredientDTO();
        }
        IngredientDTO ingredientReturn = plateDTO.getIngredientDTOS().get(0);
        ingredientReturn.setCalories(0L);
        for (IngredientDTO ingredientDTO : plateDTO.getIngredientDTOS()){
            if (getIngredientCalories(ingredientDTO.getName()) > ingredientReturn.getCalories()){
                ingredientReturn = ingredientDTO;
            }
        }
        return ingredientReturn;
    }

}
