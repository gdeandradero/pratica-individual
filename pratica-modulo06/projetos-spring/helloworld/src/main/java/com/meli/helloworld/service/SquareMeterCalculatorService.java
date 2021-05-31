package com.meli.helloworld.service;

import com.meli.helloworld.models.HouseDTO;
import com.meli.helloworld.models.RoomDTO;

import java.util.List;
import java.util.Map;

public interface SquareMeterCalculatorService {
    HouseDTO totalHouseMeter(HouseDTO houseDTO);
    HouseDTO housePrice(HouseDTO houseDTO);
    HouseDTO largestRoom(HouseDTO houseDTO);
    HouseDTO squareMeterRoom(HouseDTO houseDTO);
}
