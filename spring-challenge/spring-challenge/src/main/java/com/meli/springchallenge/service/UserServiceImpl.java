package com.meli.springchallenge.service;

import com.meli.springchallenge.dto.FollowersCountDTO;
import com.meli.springchallenge.dto.FollowersListDTO;
import com.meli.springchallenge.dto.FollowingListDTO;
import com.meli.springchallenge.dto.UserDTO;
import com.meli.springchallenge.models.Seller;
import com.meli.springchallenge.models.User;
import com.meli.springchallenge.repository.SellerRepository;
import com.meli.springchallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SellerRepository sellerRepository;

    /*
     * US 0000 - registerUser
     */
    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }

    /*
     * US 0000 - registerSeller
     */
    @Override
    public void registerSeller(Seller seller) {
        sellerRepository.save(seller);
    }


    /*
     * US 0001 - followUser
     * return true if the seller has been followed
     */
    @Override
    public boolean followUser(Long userId, Long userIdToFollow) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Seller> sellerToFollow = sellerRepository.findById(userIdToFollow);
        if (user.isPresent() && sellerToFollow.isPresent()){
            /*
             * if the user already follows the userToFollow, return the user without changes
             */
            if (user.get().getFollowingList().contains(sellerToFollow.get())){ return false; }
            /*
             * add userToFollow to the followingList of the user
             * and add user to the followersList of the userToFollow
             */
            user.get().getFollowingList().add(sellerToFollow.get());
            sellerToFollow.get().getFollowersList().add(user.get());
            userRepository.save(user.get());
            sellerRepository.save(sellerToFollow.get());
            return true;
        }
        return false;
    }

    /*
     * US 0002 - followersCount
     */
    @Override
    public FollowersCountDTO followersCount(Long sellerId) {
        Optional<Seller> seller = sellerRepository.findById(sellerId);
        if (seller.isPresent()){
            FollowersCountDTO followersCountDTO = new FollowersCountDTO(seller.get().getId(), seller.get().getName(),
                    (long) seller.get().getFollowersList().size());
            return followersCountDTO;
        }
        return new FollowersCountDTO();
    }

    /*
     * US 0003 - followersList
     */
    @Override
    public FollowersListDTO followersList(Long sellerId, String order) {
        Optional<Seller> seller = sellerRepository.findById(sellerId);
        if (seller.isPresent()){
            /*
             * adding followersList to the DTO
             */
            List<UserDTO> userDTOList = new ArrayList<>();
            for (User u : seller.get().getFollowersList()){
                UserDTO userDTO = new UserDTO(u.getId(), u.getName());
                userDTOList.add(userDTO);
            }
            /*
             * doing DTO and returning
             */
            FollowersListDTO followersListDTO = new FollowersListDTO(seller.get().getId(), seller.get().getName(),
                    userDTOList);
            if (order != null) {
                if (order.toUpperCase().compareTo("NAME_ASC") == 0) {
                    Collections.sort(followersListDTO.getFollowers());
                } else if (order.toUpperCase().compareTo("NAME_DESC") == 0) {
                    Collections.sort(followersListDTO.getFollowers(), Collections.reverseOrder());
                }
            }
            return followersListDTO;
        }
        return new FollowersListDTO();
    }

    /*
     * US 0004 - followingList
     */
    @Override
    public FollowingListDTO followingList(Long userId, String order) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()){
            /*
             * adding followingList to the DTO
             */
            List<UserDTO> userDTOList = new ArrayList<>();
            for (User u : user.get().getFollowingList()){
                UserDTO userDTO = new UserDTO(u.getId(), u.getName());
                userDTOList.add(userDTO);
            }
            /*
             * doing DTO and returning
             */
            FollowingListDTO followingListDTO = new FollowingListDTO(user.get().getId(), user.get().getName(),
                    userDTOList);
            if (order != null) {
                if (order.toUpperCase().compareTo("NAME_ASC") == 0) {
                    Collections.sort(followingListDTO.getFollowing());
                } else if (order.toUpperCase().compareTo("NAME_DESC") == 0) {
                    Collections.sort(followingListDTO.getFollowing(), Collections.reverseOrder());
                }
            }
            return followingListDTO;
        }
        return new FollowingListDTO();
    }

    /*
     * US 0007 - unfollowUser
     * return true if the seller has been unfollowed
     */
    @Override
    public boolean unfollowUser(Long userId, Long userIdToUnfollow) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Seller> sellerToUnfollow = sellerRepository.findById(userIdToUnfollow);
        if (user.isPresent() && sellerToUnfollow.isPresent()){
            /*
             * if the user dont follow the userToUnfollow, return false (no objects changed)
             */
            if (!(user.get().getFollowingList().contains(sellerToUnfollow.get()))){ return false; }
            /*
             * remove userToUnfollow to the followingList of the user
             * and remove user to the followersList of the userToUnfollow
             */
            user.get().getFollowingList().remove(sellerToUnfollow.get());
            sellerToUnfollow.get().getFollowersList().remove(user.get());
            userRepository.save(user.get());
            sellerRepository.save(sellerToUnfollow.get());
            return true;
        }
        return false;
    }
}
