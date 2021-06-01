package com.meli.springchallenge.service;

import com.meli.springchallenge.dto.FollowersCountDTO;
import com.meli.springchallenge.dto.FollowersListDTO;
import com.meli.springchallenge.dto.FollowingListDTO;
import com.meli.springchallenge.models.User;

public interface UserService {
    User registerUser(User user);
    User followUser(Long userId, Long userIdToFollow);
    FollowersCountDTO followersCount(Long userId);
    FollowersListDTO followersList(Long userId);
    FollowingListDTO followingList(Long userId);
}
