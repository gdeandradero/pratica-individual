package com.meli.springchallenge.controller;

import com.meli.springchallenge.dto.response.ResponseCountPromoDTO;
import com.meli.springchallenge.dto.response.ResponseFollowingPostsDTO;
import com.meli.springchallenge.dto.response.ResponsePromoListDTO;
import com.meli.springchallenge.dto.request.RequestPostDTO;
import com.meli.springchallenge.dto.request.RequestPromoPostDTO;
import com.meli.springchallenge.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    PostService postService;

    /*
     * US 0005 - registerPost
     */
    @PostMapping("/newpost")
    public ResponseEntity<Void> registerPost(@RequestBody @Valid RequestPostDTO requestPostDTO){
        postService.registerPost(requestPostDTO.transferToObject());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*
     * US 0006 - followingPosts
     */
    @GetMapping("/following/{userId}/list")
    public ResponseEntity<ResponseFollowingPostsDTO> followingPosts(@PathVariable Long userId,
                                                                    @RequestParam(required = false) String order){
        ResponseFollowingPostsDTO responseFollowingPostsDTO = postService.followingPosts(userId, order);
        if (responseFollowingPostsDTO.getUserId() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseFollowingPostsDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseFollowingPostsDTO);
    }

    /*
     * US 0010 - registerPromoPost
     */
    @PostMapping("/newpromopost")
    public ResponseEntity<Void> registerPromoPost(@RequestBody @Valid RequestPromoPostDTO requestPromoPostDTO){
        postService.registerPromoPost(requestPromoPostDTO.transferToObject());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*
     * US 0011 - countPromo
     */
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<ResponseCountPromoDTO> countPromo(@PathVariable Long userId){
        ResponseCountPromoDTO responseCountPromoDTO = postService.countPromo(userId);
        if (responseCountPromoDTO.getUserId() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseCountPromoDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseCountPromoDTO);
    }

    /*
     * US 0012 - promoList
     */
    @GetMapping("/{userId}/list")
    public ResponseEntity<ResponsePromoListDTO> promoList(@PathVariable Long userId){
        ResponsePromoListDTO responsePromoListDTO = postService.promoList(userId);
        if (responsePromoListDTO.getUserId() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responsePromoListDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(responsePromoListDTO);
    }

}
