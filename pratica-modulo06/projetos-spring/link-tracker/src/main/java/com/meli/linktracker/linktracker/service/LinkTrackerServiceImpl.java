package com.meli.linktracker.linktracker.service;

import com.meli.linktracker.linktracker.models.Link;
import com.meli.linktracker.linktracker.repository.LinkTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LinkTrackerServiceImpl implements LinkTrackerService {

    @Autowired
    LinkTrackerRepository linkTrackerRepository;

    @Override
    public Long registerUrl(String url) {
        Link link = new Link();
        link.setUrl(url);
        link.setNumberAccesses(0L);
        return linkTrackerRepository.save(link);
    }

    @Override
    public String accessUrl(Long id) {
        try {
            Link link = linkTrackerRepository.findById(id);
            link.setNumberAccesses(link.getNumberAccesses() + 1);
            return link.getUrl();
        } catch (NullPointerException e) {
            return "Link not found";
        }
    }

    @Override
    public Long metrics(Long id) {
        try {
            Link link = linkTrackerRepository.findById(id);
            return link.getNumberAccesses();
        } catch (NullPointerException e) {
            return 0L;
        }
    }

    @Override
    public String invalidate(Long id) {
        try {
            Link link = linkTrackerRepository.invalidate(id);
            return link.getUrl() + " set to invalid with success " + "id: " + link.getId();
        } catch (NullPointerException e) {
            return "Link not found";
        }
    }
}
