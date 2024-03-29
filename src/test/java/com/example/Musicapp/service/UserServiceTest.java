package com.example.Musicapp.service;

import com.example.Musicapp.config.JwtUtil;
import com.example.Musicapp.model.User;
import com.example.Musicapp.model.UserRole;
import com.example.Musicapp.repository.SongRepository;
import com.example.Musicapp.repository.UserRepository;
import com.example.Musicapp.repository.UserRoleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

//    @Mock
//    UserRoleRepository userRoleRepository;

    @InjectMocks
    private UserServiceImpl userService;

//    @Mock
//    private UserRoleService userRoleService;

    @Mock
    private SongService songService;

    @Mock
    private SongRepository songRepository;

    @Mock
    private JwtUtil jwtUtil;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private User user;

//    @InjectMocks
//    private UserRole userRole;

    public UserServiceTest() {
    }

    @Before
    public void initializeDummyUser(){
        user.setUsername("batman");
        user.setPassword("robin");
    }

//    @Before
//    public void initDummyUserRole(){
//        userRole.setName("ROLE_ADMIN");
//        user.setUserRole(userRole);
//    }


    @Test
    public void getUser_ReturnsUser_Success(){

        when(userRepository.findByUsername(anyString())).thenReturn(user);

        User tempUser = userService.getUser(user.getUsername());

        assertEquals(tempUser.getUsername(), user.getUsername());
    }

    @Test
    public void login_UserNotFound_Error(){

        when(userRepository.findByUsername(anyString())).thenReturn(null);

        String token = userService.login(user);

        assertNull(token);
    }

//    @Test
//    public void getUserRole_ReturnsUser_Success(){
//
//        when(userRoleRepository.findByName(anyString())).thenReturn(userRole);
//
//        UserRole tempUser = userRoleService.getRole(userRole.getName());
//
//        assertEquals(tempUser.getName(), userRole.getName());
//    }
}
