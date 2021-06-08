package com.meli.springchallenge.controller;

import com.meli.springchallenge.dto.response.ResponseFollowersCountDTO;
import com.meli.springchallenge.dto.response.ResponseFollowersListDTO;
import com.meli.springchallenge.dto.response.ResponseFollowingListDTO;
import com.meli.springchallenge.dto.request.RequestSellerDTO;
import com.meli.springchallenge.dto.request.RequestUserDTO;
import com.meli.springchallenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    /*
     * US 0001 - followUser
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> followUser(@PathVariable Long userId, @PathVariable Long userIdToFollow){
        boolean success = userService.followUser(userId, userIdToFollow);
        if (success == false){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*
     * US 0002 - followersCount
     */
    @GetMapping("/{sellerId}/followers/count")
    public ResponseEntity<ResponseFollowersCountDTO> followersCount(@PathVariable Long sellerId){
        ResponseFollowersCountDTO responseFollowersCountDTO = userService.followersCount(sellerId);
        if (responseFollowersCountDTO.getId() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseFollowersCountDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseFollowersCountDTO);
    }

    /*
     * US 0003 - followersList
     */
    @GetMapping("/{sellerId}/followers/list")
    public ResponseEntity<ResponseFollowersListDTO> followersList(@PathVariable Long sellerId,
                                                                  @RequestParam(required = false) String order){
        ResponseFollowersListDTO responseFollowersListDTO = userService.followersList(sellerId, order);
        if (responseFollowersListDTO.getId() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseFollowersListDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseFollowersListDTO);
    }

    /*
     * US 0004 - followingList
     */
    @GetMapping("/{userId}/following/list")
    public ResponseEntity<ResponseFollowingListDTO> followingList(@PathVariable Long userId,
                                                                  @RequestParam(required = false) String order){
        ResponseFollowingListDTO responseFollowingListDTO = userService.followingList(userId, order);
        if (responseFollowingListDTO.getId() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseFollowingListDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseFollowingListDTO);
    }

    /*
     * US 0007 - unfollowUser
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> unfollowUser(@PathVariable Long userId, @PathVariable Long userIdToUnfollow){
        boolean success = userService.unfollowUser(userId, userIdToUnfollow);
        if (success == false){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*
     * US 0013 - registerUser
     */
    @PostMapping("/register/user")
    public ResponseEntity<Void> registerUser(@RequestBody @Valid RequestUserDTO requestUserDTO){
        userService.registerUser(requestUserDTO.transferToObject());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*
     * US 0014 - registerSeller
     */
    @PostMapping("/register/seller")
    public ResponseEntity<Void> registerSeller(@RequestBody @Valid RequestSellerDTO requestSellerDTO){
        userService.registerSeller(requestSellerDTO.transferToObject());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
