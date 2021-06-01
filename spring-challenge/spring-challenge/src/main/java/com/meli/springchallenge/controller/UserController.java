package com.meli.springchallenge.controller;

import com.meli.springchallenge.dto.FollowersCountDTO;
import com.meli.springchallenge.dto.FollowersListDTO;
import com.meli.springchallenge.dto.FollowingListDTO;
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
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User savedUser = userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(savedUser);
    }

    /*
     * US 0001 - followUser
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<User> followUser(@PathVariable Long userId, @PathVariable Long userIdToFollow){
        User user = userService.followUser(userId, userIdToFollow);
        if (user.getId() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
    }

    /*
     * US 0002 - followersCount
     */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> followersCount(@PathVariable Long userId){
        FollowersCountDTO followersCountDTO = userService.followersCount(userId);
        if (followersCountDTO.getId() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(followersCountDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(followersCountDTO);
    }

    /*
     * US 0003 - followersList
     */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListDTO> followersList(@PathVariable Long userId){
        FollowersListDTO followersListDTO = userService.followersList(userId);
        if (followersListDTO.getId() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(followersListDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(followersListDTO);
    }

    /*
     * US 0004 - followingList
     */
    @GetMapping("/{userId}/following/list")
    public ResponseEntity<FollowingListDTO> followingList(@PathVariable Long userId){
        FollowingListDTO followingListDTO = userService.followingList(userId);
        if (followingListDTO.getId() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(followingListDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(followingListDTO);
    }


}
