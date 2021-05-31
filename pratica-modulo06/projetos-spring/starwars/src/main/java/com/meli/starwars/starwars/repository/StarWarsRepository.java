package com.meli.starwars.starwars.repository;

import java.util.List;

public interface StarWarsRepository {
    List<String> getNamesWithParam(String name);
}
