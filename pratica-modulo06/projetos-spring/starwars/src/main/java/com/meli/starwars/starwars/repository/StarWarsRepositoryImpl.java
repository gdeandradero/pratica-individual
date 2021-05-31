package com.meli.starwars.starwars.repository;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StarWarsRepositoryImpl implements StarWarsRepository {
    @Override
    public List<String> getNamesWithParam(String name) {
        List<String> namesFound = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/resources/starwars.json")){
            JSONArray namesJson = (JSONArray) jsonParser.parse(reader);
            for (Object jsonObj : namesJson){
                String jsonString = (String) ((JSONObject) jsonObj).get("name");
                if (jsonString.toUpperCase().contains(name.toUpperCase())){
                    namesFound.add(jsonString);
                }
            }
         } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return namesFound;
    }
}
