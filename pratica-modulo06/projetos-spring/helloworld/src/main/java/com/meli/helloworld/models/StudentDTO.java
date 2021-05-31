package com.meli.helloworld.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String name;
    private List<DisciplineDTO> disciplines;
    private Double average;

    public void calcAverage(){
        Double average = 0.0;
        for (DisciplineDTO disciplineDTO : this.getDisciplines()){
            average += disciplineDTO.getAverage();
        }
        this.setAverage(average / this.getDisciplines().size());
    }
}
