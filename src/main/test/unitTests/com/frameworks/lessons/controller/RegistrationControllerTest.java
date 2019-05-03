package unitTests.com.frameworks.lessons.controller;

import com.frameworks.lessons.controller.RegistrationController;
import com.frameworks.lessons.entity.User;
import com.frameworks.lessons.model.Role;
import com.frameworks.lessons.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import unitTests.com.frameworks.lessons.base.TestBase;

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

        logger.info("Checks case when email already in use ");
        assertTrue(PostMockObject("lilly", "lilly@gmail.com")
                .matches("wrongEmail"));
    }

    @Test
    public void checkWrongNameTest() throws Exception {
        testUser.setEmail("test@gmail.com");
        when(userService.findByName("lilly")).thenReturn(testUser);

        logger.info("Checks case when name already in use");
        assertTrue(PostMockObject("lilly", "test@gmail.com")
                .matches("wrongName"));
    }

    @Test
    public void checkSuccessTest() throws Exception {
        logger.info("checks when email and name are valid");
        assertTrue(PostMockObject("anna123", "test2@gmail.com")
                .matches("success"));
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

    private String PostMockObject(String lilly, String s) throws Exception {
        return mockMvc.perform(post("/checkInputs")
                .param("name", lilly)
                .param("email", s))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }
}

