package com.accenture.poc.controller;

import com.accenture.poc.model.Profile;
import com.accenture.poc.model.dto.ProfileDTO;
import com.accenture.poc.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<?> saveProfile(@RequestBody ProfileDTO profile){
        return profileService.save(profile);
    }

    @PostMapping("/strategy")
    public ResponseEntity<?> saveProfileWithStrategy(@RequestBody ProfileDTO profile){
        return profileService.saveWithStrategy(profile);
    }


    @GetMapping
    public ResponseEntity<List<Profile>> getProfiles(){
        return new ResponseEntity<>(profileService.getProfiles(), HttpStatus.OK);
    }
}
