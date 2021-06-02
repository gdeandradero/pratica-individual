package com.meli.springchallenge.service;

import com.meli.springchallenge.dto.FollowersCountDTO;
import com.meli.springchallenge.dto.FollowersListDTO;
import com.meli.springchallenge.dto.FollowingListDTO;
import com.meli.springchallenge.models.Seller;
import com.meli.springchallenge.models.User;

public interface UserService {
    void registerUser(User user);
    void registerSeller(Seller seller);
    boolean followUser(Long userId, Long userIdToFollow);
    FollowersCountDTO followersCount(Long sellerId);
    FollowersListDTO followersList(Long sellerId);
    FollowingListDTO followingList(Long userId);
}
