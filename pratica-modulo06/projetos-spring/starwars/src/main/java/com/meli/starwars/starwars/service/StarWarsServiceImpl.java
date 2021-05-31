package com.meli.starwars.starwars.service;

import com.meli.starwars.starwars.repository.StarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsServiceImpl implements StarWarsService {

    @Autowired
    StarWarsRepository starWarsRepository;

    @Override
    public List<String> getNamesWithParam(String name) {
        return starWarsRepository.getNamesWithParam(name);
    }
}
