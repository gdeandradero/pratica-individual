package com.meli.helloworld.service;

import com.meli.helloworld.models.DisciplineDTO;
import com.meli.helloworld.models.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class DegreeServiceImp implements DegreeService {

    @Override
    public StudentDTO studentAverage(StudentDTO studentDTO) {
        List<DisciplineDTO> disciplines = new ArrayList<>();
        for (DisciplineDTO disciplineDTO : studentDTO.getDisciplines()){
            disciplineDTO.calcAverage();
            disciplines.add(disciplineDTO);
        }
        studentDTO.setDisciplines(disciplines);
        studentDTO.calcAverage();
        return studentDTO;
    }

}
