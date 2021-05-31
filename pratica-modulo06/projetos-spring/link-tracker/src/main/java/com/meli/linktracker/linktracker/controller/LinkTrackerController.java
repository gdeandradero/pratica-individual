package com.meli.linktracker.linktracker.controller;

import com.meli.linktracker.linktracker.service.LinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

@RestController
public class LinkTrackerController {

    @Autowired
    LinkTrackerService linkTrackerService;

    @PostMapping("/{url}")
    public ResponseEntity<Long> registerUrl(@PathVariable String url){
        return new ResponseEntity<Long>(linkTrackerService.registerUrl(url), HttpStatus.OK);
    }

    @GetMapping("/link/{id}")
    public ModelAndView accessUrl(@PathVariable Long id) {
        String site = linkTrackerService.accessUrl(id);
        if (site.compareTo("Link not found") == 0){
            ModelAndView mv = new ModelAndView();
            mv.setStatus(HttpStatus.NOT_FOUND);
            return mv;
        }
        site = "https://" + site;
        return new ModelAndView("redirect:" + site);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<Long> metrics(@PathVariable Long id){
        return new ResponseEntity<>(linkTrackerService.metrics(id), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<String> invalidate(@PathVariable Long id){
        return new ResponseEntity<>(linkTrackerService.invalidate(id), HttpStatus.OK);
    }
}
