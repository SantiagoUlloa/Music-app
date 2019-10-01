package com.example.Musicapp.controller;

import com.example.Musicapp.Controller.UserController;
import com.example.Musicapp.config.JwtUtil;
import com.example.Musicapp.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    /**Main entry point for server-side Spring MVC test support.**/
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private JwtUtil jwtUtil;

    @Test
    public void helloWorld_ReturnsString_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/hello")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!!"));
    }

    @Test
    public void login_Success() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createUserInJson("joe","abc"));

        when(userService.login(any())).thenReturn("123456");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"token\":\"123456\"}"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

//    @Test
//    public void addCourse_Returns200_Success() throws Exception{
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .delete("/user/1");
//
//        when(userService.deleteById(anyLong())).thenReturn(HttpStatus.OK);
//
//        mockMvc.perform(requestBuilder)
//                .andExpect(status().isOk());
//    }
@Test
public void createRole_Success() throws Exception{

    RequestBuilder requestBuilder = MockMvcRequestBuilders
            .post("/login")
            .contentType(MediaType.APPLICATION_JSON)
            .content(createUserInJson("joe","abc"));

    when(userService.login(any())).thenReturn("123456");

    MvcResult result = mockMvc.perform(requestBuilder)
            .andExpect(status().isOk())
            .andExpect(content().json("{\"token\":\"123456\"}"))
            .andReturn();

    System.out.println(result.getResponse().getContentAsString());
}

    private static String createUserInJson (String name, String password) {
        return "{ \"username\": \"" + name + "\", " +
                "\"password\":\"" + password+"\"}";
    }

    private static String createUserwithRoleInJson (String name, String password, String role) {
        return "{ \"name\": \"" + name + "\", " +
                "\"password\":\"" + password +
                "\"userRole\":{"+ "\"name\": \""+ role +  "\"}}";
    }
}