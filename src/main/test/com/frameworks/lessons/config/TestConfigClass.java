package com.frameworks.lessons.config;

import com.frameworks.lessons.controller.UserController;
import com.frameworks.lessons.dao.UserDao;
import com.frameworks.lessons.service.AccountService;
import com.frameworks.lessons.service.UserService;
import com.frameworks.lessons.validator.UserValidator;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.context.annotation.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
public class TestConfigClass {

    @Bean
    public UserDao userDao() {
        return Mockito.mock(UserDao.class);
    }

    @Bean
    public WebMvcConfig webMvcConfig() {
        return Mockito.mock(WebMvcConfig.class);
    }

    @Bean
    public WebSecurityConfig webSecurityConfig() {
        return Mockito.mock(WebSecurityConfig.class);
    }

    @Bean
    public UserController userController() {
        return Mockito.mock(UserController.class);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return Mockito.mock(UserDetailsService.class);
    }

    @Bean
    public UserValidator userValidator() {
        return Mockito.mock(UserValidator.class);
    }

    @Bean
    public AccountService accountService() {
        return Mockito.mock(AccountService.class);
    }

    @Bean
    public UserService userService() {
        return Mockito.mock(UserService.class);
    }
}

