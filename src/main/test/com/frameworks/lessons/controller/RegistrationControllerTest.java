package com.frameworks.lessons.controller;

import com.frameworks.lessons.entity.User;
import com.frameworks.lessons.model.Role;
import com.frameworks.lessons.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RegistrationControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private RegistrationController registrationController;

    private MockMvc mockMvc;

    User testUser;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(registrationController).build();

        testUser = new User();
        testUser.setId(3);
        testUser.setName("lilly");
        testUser.setRole(Role.USER);
        testUser.setEmail("lilly@gmail.com");
    }

    @Test
    public void checkInputsTest() throws Exception {

        when(userService.findByEmail("lilly@gmail.com")).thenReturn(testUser);

//Chechs post request
        MvcResult result = mockMvc.perform(post("/checkInputs")
                .param("name", "lilly")
                .param("email", "lilly@gmail.com"))
                .andExpect(status().isOk())
                .andReturn();

//Checks case when email already ib use
        String content = result.getResponse().getContentAsString();
        assertTrue(content.matches("wrongEmail"));


//Checks case when name already in use
        testUser.setEmail("test@gmail.com");
        when(userService.findByName("lilly")).thenReturn(testUser);

        MvcResult result2 = mockMvc.perform(post("/checkInputs")
                .param("name", "lilly")
                .param("email", "test@gmail.com"))
                .andExpect(status().isOk())
                .andReturn();

        String content2 = result2.getResponse().getContentAsString();
        assertTrue(content2.matches("wrongName"));

//checks whem email and name are valid

        MvcResult result3 = mockMvc.perform(post("/checkInputs")
                .param("name", "anna123")
                .param("email", "test2@gmail.com"))
                .andExpect(status().isOk())
                .andReturn();

        String content3 = result3.getResponse().getContentAsString();
        assertTrue(content3.matches("success"));

    }

    @Test
    public void createNewUserTest() throws Exception {
        mockMvc.perform(post("/registration")
                .param("name", "anna123")
                .param("email", "test2@gmail.com")
                .param("password", "anna123"))
                .andExpect(redirectedUrl("/login.html"));

    }

}