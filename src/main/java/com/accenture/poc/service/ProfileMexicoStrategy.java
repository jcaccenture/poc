package com.accenture.poc.service;

import com.accenture.poc.model.dto.ProfileDTO;
import com.accenture.poc.repository.ProfileRepository;
import org.springframework.stereotype.Component;

@Component
public class ProfileMexicoStrategy implements ProfileStrategy{
    private final ProfileRepository profileRepository;
    public ProfileMexicoStrategy(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public boolean apply(String type) {
        String mexicoProfile = "MEX";
        return type.equalsIgnoreCase(mexicoProfile);
    }

    public ProfileDTO createProfile(ProfileDTO profile) {
        //CALL THE SAVE METHOD
        System.out.println("mexico strategy in action");
        return profile;
    }
}
