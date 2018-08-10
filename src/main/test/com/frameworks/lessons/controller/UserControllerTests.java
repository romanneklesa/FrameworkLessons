package com.frameworks.lessons.controller;

import com.frameworks.lessons.entity.Account;
import com.frameworks.lessons.entity.User;
import com.frameworks.lessons.model.Role;
import com.frameworks.lessons.service.AccountService;
import com.frameworks.lessons.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ComponentScan("com.frameworks.lessons")
public class UserControllerTests {

    @InjectMocks
    private UserController userController;

    @Mock
    private AccountService accountService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController, accountService)
                .setViewResolvers(resolver).build();
    }

    @Test
    public void testUserPage() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("user"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testCurrentuseraccounts() throws Exception {


    }

    @Test
    public void testUpdateAmount(){

    }
}