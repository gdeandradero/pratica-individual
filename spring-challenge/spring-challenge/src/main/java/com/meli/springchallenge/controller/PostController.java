package com.meli.springchallenge.controller;

import com.meli.springchallenge.dto.CountPromoDTO;
import com.meli.springchallenge.dto.FollowingPostsDTO;
import com.meli.springchallenge.dto.PromoListDTO;
import com.meli.springchallenge.models.Post;
import com.meli.springchallenge.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    PostService postService;

    /*
     * US 0005 - registerPost
     */
    @PostMapping("/newpost")
    public ResponseEntity<Void> registerPost(@RequestBody Post post){
        boolean success = postService.registerPost(post);
        if (success == false){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*
     * US 0006 - followingPosts
     */
    @GetMapping("/following/{userId}/list")
    public ResponseEntity<FollowingPostsDTO> followingPosts(@PathVariable Long userId,
                                                            @RequestParam(required = false) String order){
        FollowingPostsDTO followingPostsDTO = postService.followingPosts(userId, order);
        if (followingPostsDTO.getUserId() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(followingPostsDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(followingPostsDTO);
    }

    /*
     * US 0010 - registerPromoPost
     */
    @PostMapping("/newpromopost")
    public ResponseEntity<Void> registerPromoPost(@RequestBody Post post){
        boolean success = postService.registerPromoPost(post);
        if (success == false){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*
     * US 0011 - countPromo
     */
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<CountPromoDTO> countPromo(@PathVariable Long userId){
        CountPromoDTO countPromoDTO = postService.countPromo(userId);
        if (countPromoDTO.getUserId() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(countPromoDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(countPromoDTO);
    }

    /*
     * US 0012 - promoList
     */
    @GetMapping("/{userId}/list")
    public ResponseEntity<PromoListDTO> promoList(@PathVariable Long userId){
        PromoListDTO promoListDTO = postService.promoList(userId);
        if (promoListDTO.getUserId() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(promoListDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(promoListDTO);
    }

}
