package com.meli.springchallenge.service;

import com.meli.springchallenge.dto.response.ResponseCountPromoDTO;
import com.meli.springchallenge.dto.response.ResponseFollowingPostsDTO;
import com.meli.springchallenge.dto.response.ResponsePromoListDTO;
import com.meli.springchallenge.models.Post;
import com.meli.springchallenge.models.Seller;
import com.meli.springchallenge.models.User;
import com.meli.springchallenge.repository.PostRepository;
import com.meli.springchallenge.repository.SellerRepository;
import com.meli.springchallenge.repository.UserRepository;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    UserRepository userRepository;

    /*
     * US 0005
     */
    @Override
    public ResponseEntity<Void> registerPost(Post post) {
        Optional<Seller> seller = sellerRepository.findById(post.getUserId());
        if (seller.isPresent()) {
            postRepository.save(post);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*
     * US 0006
     */
    @Override
    public ResponseFollowingPostsDTO followingPosts(Long userId, String order) {
        Optional<User> user = userRepository.findById(userId);
        if (!(user.isPresent())){
            return new ResponseFollowingPostsDTO();
        }
        List<User> followingList = user.get().getFollowingList();
        List<Post> posts = new ArrayList<>();
        DateTime dateNow = new DateTime();
        for (User seller : followingList){
            for (Post post : postRepository.findAllByUserId(seller.getId())){
                DateTime convertDate = new DateTime(post.getDate());
                Duration duration = new Duration(convertDate, dateNow);
                if (duration.getStandardDays() <= 14) {
                    posts.add(post);
                }
            }
        }
        if (order != null){
            if (order.toUpperCase().compareTo("DATE_DESC") == 0){
                Collections.sort(posts, Collections.reverseOrder());
            } else {
                Collections.sort(posts);
            }
        } else {
            Collections.sort(posts);
        }
        ResponseFollowingPostsDTO responseFollowingPostsDTO = new ResponseFollowingPostsDTO(userId, posts);
        return responseFollowingPostsDTO;
    }

    /*
     * US 0010
     */
    @Override
    public ResponseEntity<Void> registerPromoPost(Post post) {
        Optional<Seller> seller = sellerRepository.findById(post.getUserId());
        if (seller.isPresent()){
            postRepository.save(post);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*
     * US 0011
     */
    @Override
    public ResponseCountPromoDTO countPromo(Long userId) {
        Optional<Seller> seller = sellerRepository.findById(userId);
        if (!(seller.isPresent())){
            return new ResponseCountPromoDTO();
        }
        Long numberPromo = 0L;
        for (Post post : postRepository.findAllByUserId(userId)){
            if (post.isHasPromo()){
                numberPromo++;
            }
        }
        return new ResponseCountPromoDTO(seller.get().getId(), seller.get().getName(), numberPromo);
    }

    /*
     * US 0012
     */
    @Override
    public ResponsePromoListDTO promoList(Long userId) {
        Optional<Seller> seller = sellerRepository.findById(userId);
        if (!(seller.isPresent())){
            return new ResponsePromoListDTO();
        }
        ResponsePromoListDTO responsePromoListDTO = new ResponsePromoListDTO(seller.get().getId(), seller.get().getName(), new ArrayList<>());
        for (Post post : postRepository.findAllByUserId(seller.get().getId())){
            if (post.isHasPromo()){
                responsePromoListDTO.getPosts().add(post);
            }
        }
        return responsePromoListDTO;
    }
}
