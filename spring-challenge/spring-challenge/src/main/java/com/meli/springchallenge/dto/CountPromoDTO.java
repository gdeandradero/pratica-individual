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
 * US 0011
 */
public class CountPromoDTO {
    private Long userId;
    private String userName;
    private Long promoProductsCount;
}
