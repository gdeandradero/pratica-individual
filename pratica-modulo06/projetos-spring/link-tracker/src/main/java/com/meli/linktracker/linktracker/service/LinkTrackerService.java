package com.meli.linktracker.linktracker.service;

import com.meli.linktracker.linktracker.models.Link;

public interface LinkTrackerService {
    Long registerUrl(String url);
    String accessUrl(Long id);
    Long metrics(Long id);
    String invalidate(Long id);
}
