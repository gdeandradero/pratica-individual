package com.meli.springchallenge.service;

import com.meli.springchallenge.dto.CountPromoDTO;
import com.meli.springchallenge.dto.FollowingPostsDTO;
import com.meli.springchallenge.dto.PromoListDTO;
import com.meli.springchallenge.models.Post;

public interface PostService {
    void registerPost(Post post);
    FollowingPostsDTO followingPosts(Long userId, String order);
    void registerPromoPost(Post post);
    CountPromoDTO countPromo(Long userId);
    PromoListDTO promoList(Long userId);
}
