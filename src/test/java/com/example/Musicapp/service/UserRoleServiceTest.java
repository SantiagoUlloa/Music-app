package com.example.Musicapp.service;


import com.example.Musicapp.config.JwtUtil;
import com.example.Musicapp.model.User;
import com.example.Musicapp.model.UserRole;
import com.example.Musicapp.repository.UserRoleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRoleServiceTest {

    @Mock
    private UserRoleRepository userRoleRepository;

    @Mock
    private UserRoleService userRoleService;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private UserRoleServiceImpl userRoleServiceImpl;

    @InjectMocks
    private User user;

    @InjectMocks
    private UserRole userRole;

    public UserRoleServiceTest() {
    }

    @Before
    public void initDummyUserRole(){
        userRole.setName("ROLE_ADMIN");
//        user.setUserRole(userRole);
    }

    @Test
    public void getUserRole_ReturnsUser_Success(){

        when(userRoleRepository.findByName(anyString())).thenReturn(userRole);

        UserRole tempUser = userRoleServiceImpl.getRole(userRole.getName());

        assertEquals(tempUser.getName(), userRole.getName());
    }

    @Test
    public void getUserRole_UserRoleNotFound_Error(){

        when(userRoleRepository.findByName(anyString())).thenReturn(null);

//        String token = userRoleService.getRole();

//        assertNull();
    }

}
