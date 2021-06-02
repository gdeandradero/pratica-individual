package com.meli.springchallenge.dto;

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
 * US 0006
 */
public class FollowingPostsDTO {
    private Long userId;
    private List<Post> posts;
}
