package com.accenture.poc.service;

import com.accenture.poc.model.dto.ProfileDTO;
import org.springframework.stereotype.Component;

@Component
public interface ProfileStrategy {


    public boolean apply(String type);

    public ProfileDTO createProfile(ProfileDTO profile);
}
