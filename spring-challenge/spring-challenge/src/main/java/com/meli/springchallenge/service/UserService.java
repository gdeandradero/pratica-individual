package com.meli.springchallenge.service;

import com.meli.springchallenge.dto.FollowersCountDTO;
import com.meli.springchallenge.dto.FollowersListDTO;
import com.meli.springchallenge.dto.FollowingListDTO;
import com.meli.springchallenge.models.Seller;
import com.meli.springchallenge.models.User;

public interface UserService {
    boolean followUser(Long userId, Long userIdToFollow);
    FollowersCountDTO followersCount(Long sellerId);
    FollowersListDTO followersList(Long sellerId, String order);
    FollowingListDTO followingList(Long userId, String order);
    boolean unfollowUser(Long userId, Long userIdToUnfollow);
    void registerUser(User user);
    void registerSeller(Seller seller);
}
