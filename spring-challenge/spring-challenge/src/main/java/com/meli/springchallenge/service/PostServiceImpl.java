package com.meli.springchallenge.service;

import com.meli.springchallenge.dto.CountPromoDTO;
import com.meli.springchallenge.dto.FollowingPostsDTO;
import com.meli.springchallenge.dto.PromoListDTO;
import com.meli.springchallenge.models.Post;
import com.meli.springchallenge.models.Seller;
import com.meli.springchallenge.models.User;
import com.meli.springchallenge.repository.PostRepository;
import com.meli.springchallenge.repository.SellerRepository;
import com.meli.springchallenge.repository.UserRepository;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean registerPost(Post post) {
        Optional<Seller> seller = sellerRepository.findById(post.getUserId());
        if (!(seller.isPresent())){
            return false;
        }
        postRepository.save(post);
        return true;
    }

    /*
     * US 0006
     */
    @Override
    public FollowingPostsDTO followingPosts(Long userId, String order) {
        Optional<User> user = userRepository.findById(userId);
        if (!(user.isPresent())){
            return new FollowingPostsDTO();
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
        FollowingPostsDTO followingPostsDTO = new FollowingPostsDTO(userId, posts);
        return followingPostsDTO;
    }

    /*
     * US 0010
     */
    @Override
    public boolean registerPromoPost(Post post) {
        Optional<Seller> seller = sellerRepository.findById(post.getUserId());
        if (!(seller.isPresent())){
            return false;
        }
        postRepository.save(post);
        return true;
    }

    /*
     * US 0011
     */
    @Override
    public CountPromoDTO countPromo(Long userId) {
        Optional<Seller> seller = sellerRepository.findById(userId);
        if (!(seller.isPresent())){
            return new CountPromoDTO();
        }
        Long numberPromo = 0L;
        for (Post post : postRepository.findAllByUserId(userId)){
            if (post.isHasPromo()){
                numberPromo++;
            }
        }
        return new CountPromoDTO(seller.get().getId(), seller.get().getName(), numberPromo);
    }

    /*
     * US 0012
     */
    @Override
    public PromoListDTO promoList(Long userId) {
        Optional<Seller> seller = sellerRepository.findById(userId);
        if (!(seller.isPresent())){
            return new PromoListDTO();
        }
        PromoListDTO promoListDTO = new PromoListDTO(seller.get().getId(), seller.get().getName(), new ArrayList<>());
        for (Post post : postRepository.findAllByUserId(seller.get().getId())){
            if (post.isHasPromo()){
                promoListDTO.getPosts().add(post);
            }
        }
        return promoListDTO;
    }
}
