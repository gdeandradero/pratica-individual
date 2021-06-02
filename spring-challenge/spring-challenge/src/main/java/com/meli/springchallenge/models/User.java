package com.meli.springchallenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    /* @ManyToMany
     @JsonIgnore
     private List<User> followersList;*/
    @ManyToMany
    @JsonIgnore
    private List<User> followingList;

    public User(){
        // this.followersList = new ArrayList<>();
        this.followingList = new ArrayList<>();
    }

    public User(String name) {
        this.name = name;
        // this.followersList = new ArrayList<>();
        this.followingList = new ArrayList<>();
    }
}
