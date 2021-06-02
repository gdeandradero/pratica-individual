package com.meli.springchallenge.controller;

import com.meli.springchallenge.dto.FollowersCountDTO;
import com.meli.springchallenge.dto.FollowersListDTO;
import com.meli.springchallenge.dto.FollowingListDTO;
import com.meli.springchallenge.models.Seller;
import com.meli.springchallenge.models.User;
import com.meli.springchallenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    /*
     * US 0000 - registerUser
     */
    @PostMapping("/register/user")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void registerUser(@RequestBody User user){
        userService.registerUser(user);
    }

    /*
     * US 0000 - registerSeller
     */
    @PostMapping("/register/seller")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void registerSeller(@RequestBody Seller seller){
        userService.registerSeller(seller);
    }

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
    public ResponseEntity<FollowersCountDTO> followersCount(@PathVariable Long sellerId){
        FollowersCountDTO followersCountDTO = userService.followersCount(sellerId);
        if (followersCountDTO.getId() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(followersCountDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(followersCountDTO);
    }

    /*
     * US 0003 - followersList
     */
    @GetMapping("/{sellerId}/followers/list")
    public ResponseEntity<FollowersListDTO> followersList(@PathVariable Long sellerId,
                                                          @RequestParam(required = false) String order){
        FollowersListDTO followersListDTO = userService.followersList(sellerId, order);
        if (followersListDTO.getId() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(followersListDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(followersListDTO);
    }

    /*
     * US 0004 - followingList
     */
    @GetMapping("/{userId}/following/list")
    public ResponseEntity<FollowingListDTO> followingList(@PathVariable Long userId,
                                                          @RequestParam(required = false) String order){
        FollowingListDTO followingListDTO = userService.followingList(userId, order);
        if (followingListDTO.getId() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(followingListDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(followingListDTO);
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
}
