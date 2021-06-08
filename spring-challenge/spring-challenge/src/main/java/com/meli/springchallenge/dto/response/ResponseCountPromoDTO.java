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
 * US 0011
 */
public class ResponseCountPromoDTO {
    private Long userId;
    private String userName;
    private Long promoProductsCount;
}
