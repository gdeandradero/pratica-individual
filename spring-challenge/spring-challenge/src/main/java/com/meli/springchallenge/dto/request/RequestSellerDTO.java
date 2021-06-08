package com.meli.springchallenge.dto.request;

import com.meli.springchallenge.models.Seller;
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
 * US 0014 - Request registerSeller
 */
public class RequestSellerDTO {
    @NotBlank(message = "{name.not.blank}")
    private String name;

    public Seller transferToObject(){
        return new Seller(name);
    }
}
