package com.meli.springchallenge.service;

import com.meli.springchallenge.dto.response.ResponseCountPromoDTO;
import com.meli.springchallenge.dto.response.ResponseFollowingPostsDTO;
import com.meli.springchallenge.dto.response.ResponsePromoListDTO;
import com.meli.springchallenge.models.Post;
import org.springframework.http.ResponseEntity;

public interface PostService {
    ResponseEntity<Void> registerPost(Post post);
    ResponseFollowingPostsDTO followingPosts(Long userId, String order);
    ResponseEntity<Void> registerPromoPost(Post post);
    ResponseCountPromoDTO countPromo(Long userId);
    ResponsePromoListDTO promoList(Long userId);
}
