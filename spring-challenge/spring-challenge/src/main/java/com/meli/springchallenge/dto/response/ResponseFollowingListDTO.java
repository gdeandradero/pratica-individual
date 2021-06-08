package com.meli.springchallenge.dto.response;

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
 * US 0004
 */
public class ResponseFollowingListDTO {
    private Long id;
    private String name;
    private List<ResponseUserDTO> following;
}
