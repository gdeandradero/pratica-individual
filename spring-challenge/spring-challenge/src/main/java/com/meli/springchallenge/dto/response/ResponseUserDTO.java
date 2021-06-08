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
 * used in US 0003, US 0004
 */
public class ResponseUserDTO implements Comparable<ResponseUserDTO> {
    private Long id;
    private String name;

    @Override
    public int compareTo(ResponseUserDTO o) {
        return this.name.compareTo(o.name);
    }
}
