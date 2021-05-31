package com.meli.helloworld.controller;

import com.meli.helloworld.models.StudentDTO;
import com.meli.helloworld.service.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/degree")
public class DegreeController {

    @Autowired
    DegreeService degreeService;

    @PostMapping("/student-average")
    public ResponseEntity<String> studentAverage(@RequestBody StudentDTO studentDTO){
        studentDTO = degreeService.studentAverage(studentDTO);
        String s = "";
        if (studentDTO.getAverage() > 9){
            s = "Good job! " + studentDTO.getAverage();
        } else {
            s = "The rate equals = " + studentDTO.getAverage();
        }
        return new ResponseEntity<String>(s, HttpStatus.OK);
    }

}
