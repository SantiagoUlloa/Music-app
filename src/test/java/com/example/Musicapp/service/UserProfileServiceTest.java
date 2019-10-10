package com.example.Musicapp.service;

import com.example.Musicapp.model.UserProfile;
import com.example.Musicapp.repository.UserProfileRepositoryStub;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserProfileServiceTest {

    private UserProfileServiceImpl userProfileService;

    @Before
    public void initializeUserProfile(){
        userProfileService = new UserProfileServiceImpl(new UserServiceStub(), new UserProfileRepositoryStub());
    }

    @Test
    public void createUserProfile_AddsProfile_Success(){

        UserProfile userProfile = new UserProfile();
        userProfile.setEmail("batman1@superhero.com");

        UserProfile newProfile = userProfileService.createUserProfile("batman1", userProfile);

        Assert.assertNotNull(newProfile);
        Assert.assertEquals(newProfile.getEmail(), userProfile.getEmail());
    }

    @Test
    public void getUserProfile_RetrievesProfileByUsername_Success(){

    }
}
