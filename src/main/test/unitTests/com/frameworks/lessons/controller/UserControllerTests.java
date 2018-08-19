package unitTests.com.frameworks.lessons.controller;

import com.frameworks.lessons.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import unitTests.com.frameworks.lessons.base.TestBase;
import unitTests.com.frameworks.lessons.config.TestConfigClass;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfigClass.class})
public class UserControllerTests extends TestBase {

    private MockMvc mvc;

    @InjectMocks
    UserController controller;

    @Before
    public void init() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        this.mvc = MockMvcBuilders.standaloneSetup(controller).setViewResolvers(viewResolver).build();
    }

    @Test
    public void testUserPage() throws Exception {
        logger.info("Ckeck that status 200 and name='user'");
        mvc.perform(get("/user")).andExpect(status().isOk())
                .andExpect(view().name("user"));
    }
}