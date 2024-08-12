package com.accenture.poc.controller;

import com.accenture.poc.model.dto.ProfileDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("usa")
@RestController
@RequestMapping("/profiles")
public class ProfilesUsaController {

    @PostMapping
    public ResponseEntity<String> saveProfile(@RequestBody ProfileDTO p){
        return new ResponseEntity<>("entity saved using usa profile ", HttpStatus.CREATED);
    }

}
