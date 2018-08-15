package com.frameworks.lessons.dao;

import com.frameworks.lessons.config.AppConfig;
import com.frameworks.lessons.config.WebSecurityConfig;
import com.frameworks.lessons.entity.User;
import com.frameworks.lessons.model.Role;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebSecurityConfig.class, AppConfig.class})
public class UserDaoImplTests {

    @Mock
    private UserDao userDao;

    @Mock
    private SessionFactory sessionFactory;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUser(){
        User mockedUser = new User();

        mockedUser.setId(1);

        when(userDao.getUser(1)).thenReturn(mockedUser);

    }

    @Test
    public void testAddUser(){
        User mockedUser = new User();
        userDao.add(mockedUser);

        int id = mockedUser.getId();
        Assert.assertNotNull(id);

    }


    @Test
    public void testSave(){
        userDao.add(getSampleUser());

    }

    @Test
    public void findAllEmployees(){
        Assert.assertEquals(userDao.listUsers().size(),anyInt());
    }



    public User getSampleUser(){
        User user = new User();
        user.setName("arminvb");
        user.setId(34);
        user.setPassword("qweee");
        user.setEmail("armin@i.ua");
        user.setRole(Role.USER);
        return user;
    }

}
