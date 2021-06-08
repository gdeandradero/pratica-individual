package com.meli.springchallenge.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.meli.springchallenge.models.Post;
import com.meli.springchallenge.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/*
 * US 0010 - Request registerPromoPost
 */
public class RequestPromoPostDTO {
    @NotNull(message = "{userId.not.null}")
    private Long userId;
    @JsonFormat(pattern="dd-MM-yyyy")
    @NotNull(message = "{date.not.null}")
    private Date date;
    @NotBlank(message = "{name.not.blank}")
    private String name;
    @NotBlank(message = "{type.not.blank}")
    private String type;
    @NotBlank(message = "{brand.not.blank}")
    private String brand;
    @NotBlank(message = "{color.not.blank}")
    private String color;
    @NotBlank(message = "{notes.not.blank}")
    private String notes;
    @NotNull(message = "{category.not.null}")
    private Long category;
    @NotNull(message = "{price.not.null}")
    private Double price;
    @NotNull(message = "{hasPromo.not.null}")
    private boolean hasPromo;
    @NotNull(message = "{discount.not.null}")
    private Double discount;

    public Post transferToObject(){
        Product detail = new Product();
        detail.setName(name);
        detail.setType(type);
        detail.setBrand(brand);
        detail.setColor(color);
        detail.setNotes(notes);
        Post post = new Post();
        post.setUserId(userId);
        post.setDate(date);
        post.setDetail(detail);
        post.setCategory(category);
        post.setPrice(price);
        post.setHasPromo(hasPromo);
        post.setDiscount(discount);
        return post;
    }
}
