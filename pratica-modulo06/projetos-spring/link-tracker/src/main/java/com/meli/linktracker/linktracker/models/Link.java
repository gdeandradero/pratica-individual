package com.meli.linktracker.linktracker.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
public class Link {
    private static Long count = 0L;
    public static List<Link> allLinks;

    private Long id;
    private String url;
    private Long numberAccesses;

    public Link(){
        count++;
        this.id = count;
    }
}
