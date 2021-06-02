package com.meli.springchallenge.service;

import com.meli.springchallenge.dto.FollowingPostsDTO;
import com.meli.springchallenge.models.Post;

public interface PostService {
    boolean registerPost(Post post);
    FollowingPostsDTO followingPosts(Long userId, String order);
}
