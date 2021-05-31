package com.meli.helloworld.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DisciplineDTO {
    private String name;
    private List<Double> rates;
    private Double average;

    public void calcAverage(){
        Double averageMethod = 0.0;
        for (Double d : this.getRates()){
            averageMethod += d;
        }
        averageMethod = averageMethod / this.getRates().size();
        this.setAverage(averageMethod);
    }
}
