package com.example.Musicapp.service;

import com.example.Musicapp.model.UserProfile;

public class UserProfileServiceStub implements UserProfileService {

    @Override
    public UserProfile createUserProfile(String username, UserProfile newProfile) {
        UserProfile userProfile = new UserProfile();
        userProfile.setEmail("batman@superhero.com");

        return userProfile;
    }

    @Override
    public UserProfile getUserProfile(String username) {
        return null;
    }
}
