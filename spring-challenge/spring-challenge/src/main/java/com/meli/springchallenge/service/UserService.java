package com.meli.springchallenge.service;

import com.meli.springchallenge.dto.response.ResponseFollowersCountDTO;
import com.meli.springchallenge.dto.response.ResponseFollowersListDTO;
import com.meli.springchallenge.dto.response.ResponseFollowingListDTO;
import com.meli.springchallenge.models.Seller;
import com.meli.springchallenge.models.User;

public interface UserService {
    boolean followUser(Long userId, Long userIdToFollow);
    ResponseFollowersCountDTO followersCount(Long sellerId);
    ResponseFollowersListDTO followersList(Long sellerId, String order);
    ResponseFollowingListDTO followingList(Long userId, String order);
    boolean unfollowUser(Long userId, Long userIdToUnfollow);
    void registerUser(User user);
    void registerSeller(Seller seller);
}
