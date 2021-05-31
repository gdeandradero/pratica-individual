package com.meli.caloriecalculator.caloriecalculator.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDTO {
    private String name;
    private Double peso;
    private Long calories;
}
