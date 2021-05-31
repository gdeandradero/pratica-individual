package com.meli.linktracker.linktracker.repository;

import com.meli.linktracker.linktracker.models.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class LinkTrackerRepositoryImpl implements LinkTrackerRepository {
    @Override
    public Long save(Link link) {
        addLink(link);
        return link.getId();
    }

    @Override
    public Link findById(Long id) {
        if (Link.allLinks == null){
            return null;
        }
        for (Link link : Link.allLinks){
            if (link.getId() == id){
                return link;
            }
        }
        return null;
    }

    @Override
    public Link invalidate(Long id) {
        if (Link.allLinks == null){
            return null;
        }
        for (Link link : Link.allLinks){
            if (link.getId() == id){
                link.setId(0L);
                return link;
            }
        }
        return null;
    }

    public void addLink(Link link){
        if (Link.allLinks == null){
            Link.allLinks = new ArrayList<Link>();
        }
        Link.allLinks.add(link);
    }
}
