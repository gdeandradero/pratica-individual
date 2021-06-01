package com.meli.springchallenge.service;

import com.meli.springchallenge.dto.FollowersCountDTO;
import com.meli.springchallenge.dto.FollowersListDTO;
import com.meli.springchallenge.dto.FollowingListDTO;
import com.meli.springchallenge.dto.UserDTO;
import com.meli.springchallenge.models.User;
import com.meli.springchallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /*
     * US 0000
     */
    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    /*
     * US 0001 - followUser
     */
    @Override
    public User followUser(Long userId, Long userIdToFollow) {
        Optional<User> user = userRepository.findById(userId);
        Optional<User> userToFollow = userRepository.findById(userIdToFollow);
        if (user.isPresent() && userToFollow.isPresent()){
            /*
             * if the user already follows the userToFollow, return the user without changes
             */
            if (user.get().getFollowingList().contains(userToFollow.get())){
                return user.get();
            }
            /*
             * add userToFollow to the followingList of the user
             * and add user to the followersList of the userToFollow
             */
            user.get().getFollowingList().add(userToFollow.get());
            userToFollow.get().getFollowersList().add(user.get());
            userRepository.save(user.get());
            userRepository.save(userToFollow.get());
            return user.get();
        }
        return new User();
    }

    /*
     * US 0002 - followersCount
     */
    @Override
    public FollowersCountDTO followersCount(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()){
            FollowersCountDTO followersCountDTO = new FollowersCountDTO(user.get().getId(), user.get().getName(),
                    (long) user.get().getFollowersList().size());
            return followersCountDTO;
        }
        return new FollowersCountDTO();
    }

    /*
     * US 0003 - followersList
     */
    @Override
    public FollowersListDTO followersList(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()){
            /*
             * adding followersList to the DTO
             */
            List<UserDTO> userDTOList = new ArrayList<>();
            for (User u : user.get().getFollowersList()){
                UserDTO userDTO = new UserDTO(u.getId(), u.getName());
                userDTOList.add(userDTO);
            }
            /*
             * doing DTO and returning
             */
            FollowersListDTO followersListDTO = new FollowersListDTO(user.get().getId(), user.get().getName(),
                    userDTOList);
            return followersListDTO;
        }
        return new FollowersListDTO();
    }

    /*
     * US 0004 - followingList
     */
    @Override
    public FollowingListDTO followingList(Long userId) {
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
            return followingListDTO;
        }
        return new FollowingListDTO();
    }
}
