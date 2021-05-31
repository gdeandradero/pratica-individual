package com.meli.helloworld.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Service
public class CalculatorServiceImp implements CalculatorService {

    @Override
    public Integer convertDateToAge(Integer year, Integer month, Integer day) {
        LocalDate dateNow = LocalDate.now();
        LocalDate birthDate = LocalDate.of(year, month, day);
        Period age = Period.between(birthDate, dateNow);
        return Integer.valueOf(String.valueOf(age.getYears()));
    }

}
