package com.meli.springchallenge.dto;

import com.meli.springchallenge.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/*
 * used in US 0003, US 0004
 */
public class UserDTO implements Comparable<UserDTO> {
    private Long id;
    private String name;

    @Override
    public int compareTo(UserDTO o) {
        return this.name.compareTo(o.name);
    }
}
