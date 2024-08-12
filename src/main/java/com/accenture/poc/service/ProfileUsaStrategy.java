package com.accenture.poc.service;

import com.accenture.poc.model.dto.ProfileDTO;
import com.accenture.poc.repository.ProfileRepository;
import org.springframework.stereotype.Component;

@Component
public class ProfileUsaStrategy implements ProfileStrategy{
    private final ProfileRepository profileRepository;

    public ProfileUsaStrategy(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public boolean apply(String type) {
        String usaProfile = "USA";
        return type.equalsIgnoreCase(usaProfile);
    }

    public ProfileDTO createProfile(ProfileDTO profile) {
        System.out.println("usa strategy in action");
        return profile;
    }
}
