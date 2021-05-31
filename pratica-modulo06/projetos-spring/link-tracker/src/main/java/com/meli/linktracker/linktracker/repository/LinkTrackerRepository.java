package com.meli.linktracker.linktracker.repository;

import com.meli.linktracker.linktracker.models.Link;

public interface LinkTrackerRepository {
    Long save(Link link);
    Link findById(Long id);
    Link invalidate(Long id);
}
