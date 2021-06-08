package com.meli.springchallenge.dto.response;

import com.meli.springchallenge.models.Post;
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
 * US 0012
 */
public class ResponsePromoListDTO {
    private Long userId;
    private String userName;
    private List<Post> posts;
}
