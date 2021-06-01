package com.meli.springchallenge.dto;

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
public class FollowersCountDTO {
    private Long id;
    private String name;
    private Long followersNumber;
}
