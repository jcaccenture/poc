package com.accenture.poc.service;

import com.accenture.poc.model.Profile;
import com.accenture.poc.model.dto.ProfileDTO;
import com.accenture.poc.repository.ProfileRepository;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ModelMapper mapper;
    private final List<ProfileStrategy> profilesStrategy;
    private final Environment environment;

    public ProfileService(ProfileRepository profileRepository, ModelMapper mapper, List<ProfileStrategy> profilesStrategy, Environment environment) {
        this.profileRepository = profileRepository;
        this.mapper = mapper;
        this.profilesStrategy = profilesStrategy;
        this.environment = environment;
    }

    public ResponseEntity<?> save(ProfileDTO profileRequest){

        var profile = mapper.map(profileRequest, Profile.class);
        var profileSaved = profileRepository.save(profile);
        if(Objects.nonNull(profileSaved.getId())){
            return new ResponseEntity<>(mapper.map(profileSaved, ProfileDTO.class) , HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Something went wrong please try again",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public List<Profile> getProfiles(){
        return profileRepository.findAll();
    }

    public ResponseEntity<?> saveWithStrategy(ProfileDTO profileDTO){
        var profiles = environment.getActiveProfiles();
        profilesStrategy.forEach(profileStrategy -> {
            if(profileStrategy.apply(profiles[0])){
                profileStrategy.createProfile(profileDTO);
            }
        });
        return new ResponseEntity<>("CREATED USING A STRATEGY", HttpStatus.CREATED);
    }
}
