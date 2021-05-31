package com.meli.helloworld.service;

import com.meli.helloworld.models.HouseDTO;
import com.meli.helloworld.models.RoomDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SquareMeterCalculatorServiceImp implements SquareMeterCalculatorService {

    @Override
    public HouseDTO totalHouseMeter(HouseDTO houseDTO) {
        Double result = 0.0;
        for (RoomDTO roomDTO : houseDTO.getRoomDTOS()){
            result += roomDTO.getHeight() * roomDTO.getWidth();
        }
        houseDTO.setTotalSize(result);
        return houseDTO;
    }

    @Override
    public HouseDTO housePrice(HouseDTO houseDTO) {
        totalHouseMeter(houseDTO);
        houseDTO.setTotalPrice(houseDTO.getTotalSize() * 800);
        return houseDTO;
    }

    @Override
    public HouseDTO largestRoom(HouseDTO houseDTO) {
        RoomDTO largestRoom = new RoomDTO();
        largestRoom.setHeight(0.0);
        largestRoom.setWidth(0.0);
        for (RoomDTO roomDTO : houseDTO.getRoomDTOS()){
            if (roomDTO.getHeight() * roomDTO.getWidth()
                    > largestRoom.getHeight() * largestRoom.getWidth()){
                largestRoom = roomDTO;
            }
        }
        houseDTO.setLargestRoom(largestRoom);
        return houseDTO;
    }

    @Override
    public HouseDTO squareMeterRoom(HouseDTO houseDTO) {
        List<RoomDTO> rooms = new ArrayList<>();
        houseDTO.getRoomDTOS().forEach((RoomDTO room) ->{
            room.setSquareMeter(room.getHeight() * room.getWidth());
        });
        return houseDTO;
    }

}
