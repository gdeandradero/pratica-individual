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
public class HouseDTO {
    private String name;
    private String adress;
    private List<RoomDTO> roomDTOS;
    private Double totalSize;
    private Double totalPrice;
    private RoomDTO largestRoom;
}
