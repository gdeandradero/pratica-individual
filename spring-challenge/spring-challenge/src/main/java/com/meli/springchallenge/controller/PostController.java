package com.meli.springchallenge.controller;

import com.meli.springchallenge.models.Post;
import com.meli.springchallenge.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/newpost")
    public ResponseEntity<Post> registerPost(@RequestBody Post post){
        Post savedPost = postService.registerPost(post);
        return ResponseEntity.status(HttpStatus.OK).body(savedPost);
    }

}
