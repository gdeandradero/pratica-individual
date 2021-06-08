package com.meli.springchallenge.dto.request;

import com.meli.springchallenge.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/*
 * US 0013 - Request registerUser
 */
public class RequestUserDTO {
    @NotBlank(message = "{name.not.blank}")
    private String name;

    public User transferToObject(){
        return new User(name);
    }
}
