package com.meli.springchallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/*
 * US 0003
 */
public class FollowersListDTO {
    private Long id;
    private String name;
    private List<UserDTO> followers;
}
