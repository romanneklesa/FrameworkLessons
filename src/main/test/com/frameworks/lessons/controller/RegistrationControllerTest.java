package com.frameworks.lessons.controller;

import com.frameworks.lessons.base.TestBase;
import com.frameworks.lessons.entity.User;
import com.frameworks.lessons.model.Role;
import com.frameworks.lessons.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RegistrationControllerTest extends TestBase {
    public User testUser;

    @Mock
    public UserService userService;

    @InjectMocks
    public RegistrationController registrationController;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(registrationController).build();
        testUser = new User();
        testUser.setId(3);
        testUser.setName("lilly");
        testUser.setRole(Role.USER);
        testUser.setEmail("lilly@gmail.com");
    }

    @Test
    public void checkWrongEmailTest() throws Exception {
        when(userService.findByEmail("lilly@gmail.com")).thenReturn(testUser);

        MvcResult result = mockMvc.perform(post("/checkInputs")
                .param("name", "lilly")
                .param("email", "lilly@gmail.com"))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();

        logger.info("Checks case when email already in use ");
        assertTrue(content.matches("wrongEmail"));
    }

    @Test
    public void checkWrongNameTest() throws Exception {

        testUser.setEmail("test@gmail.com");
        when(userService.findByName("lilly")).thenReturn(testUser);

        MvcResult result2 = mockMvc.perform(post("/checkInputs")
                .param("name", "lilly")
                .param("email", "test@gmail.com"))
                .andExpect(status().isOk())
                .andReturn();

        String content2 = result2.getResponse().getContentAsString();

        logger.info("Checks case when name already in use");
        assertTrue(content2.matches("wrongName"));
    }

    @Test
    public void checkSuccessTest() throws Exception {
        MvcResult result3 = mockMvc.perform(post("/checkInputs")
                .param("name", "anna123")
                .param("email", "test2@gmail.com"))
                .andExpect(status().isOk())
                .andReturn();

        String content3 = result3.getResponse().getContentAsString();

        logger.info("checks when email and name are valid");
        assertTrue(content3.matches("success"));
    }

    @Test
    public void createNewUserTest() throws Exception {
        logger.info("checks when email and name are valid");
        mockMvc.perform(post("/registration")
                .param("name", "anna123")
                .param("email", "test2@gmail.com")
                .param("password", "anna123"))
                .andExpect(redirectedUrl("/login.html"));
    }
}

