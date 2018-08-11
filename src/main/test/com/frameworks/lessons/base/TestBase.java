package com.frameworks.lessons.base;

import com.frameworks.lessons.controller.RegistrationController;
import com.frameworks.lessons.dao.impl.AccountDaoImpl;
import com.frameworks.lessons.entity.User;
import com.frameworks.lessons.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class TestBase {
    public static final Logger logger = LoggerFactory.getLogger(AccountDaoImpl.class);
    public MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
    }
}
