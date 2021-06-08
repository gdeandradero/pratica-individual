package com.meli.springchallenge.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/*
 * US 0002
 */
public class ResponseFollowersCountDTO {
    private Long id;
    private String name;
    private Long followersNumber;
}
