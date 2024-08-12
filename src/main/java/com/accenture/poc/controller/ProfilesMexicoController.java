package com.accenture.poc.controller;

import com.accenture.poc.model.dto.ProfileDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("mex")
@RestController
@RequestMapping("/profiles")
public class ProfilesMexicoController {


    @PostMapping
    public ResponseEntity<String> saveProfile(@RequestBody ProfileDTO profile){
        return new ResponseEntity<>("entity saved using mex profile ", HttpStatus.CREATED);
    }
}
