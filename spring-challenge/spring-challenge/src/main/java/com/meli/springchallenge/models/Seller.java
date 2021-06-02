package com.meli.springchallenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Seller extends User {
    @ManyToMany
    @JsonIgnore
    private List<User> followersList;

    public Seller(){
        this.followersList = new ArrayList<>();
        this.setFollowingList(new ArrayList<>());
    }

    public Seller(String name) {
        this.setName(name);
        this.followersList = new ArrayList<>();
        this.setFollowingList(new ArrayList<>());
    }
}
