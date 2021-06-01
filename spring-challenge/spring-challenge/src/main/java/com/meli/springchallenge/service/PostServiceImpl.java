package com.meli.springchallenge.service;

import com.meli.springchallenge.models.Post;
import com.meli.springchallenge.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public Post registerPost(Post post) {
        return postRepository.save(post);
    }
}
