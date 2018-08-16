package com.frameworks.lessons.dao;

import com.frameworks.lessons.entity.User;
import com.frameworks.lessons.model.Role;
import org.hibernate.ObjectNotFoundException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserDaoImplTest extends EntityDaoImplTest {

    @Test
    public void addTest() {
        User user = new User();
        user.setId(3);
        user.setName("Nelson");
        user.setEmail("Nelson@gmail.com");
        user.setPassword("ljhgjkhg");
        user.setRole(Role.USER);

        userDao.add(user);
        Assert.assertEquals(userDao.getUser(3), user, "Database has the same user");
    }

    @Test(expectedExceptions = ObjectNotFoundException.class)
    public void getUserExeptionTest() {
        userDao.getUser(10);
    }

    @Test
    public void getUserTest() {
        Assert.assertNotNull(userDao.getUser(1), "There is user with id 1 in test db");
    }


    //delete method does not work properly so far
//    @Test
//    public void deleteUserTest(){
//        User user = userDao.getUser(1);
//        Assert.assertTrue(userDao.listUsers().contains(user), "There is user with id 1 in test db");
//        userDao.deleteUser(1);
//        Assert.assertFalse(userDao.listUsers().contains(user), "There is NO user with id 1 in test db");
//
//    }

    @Test
    public void updateUserTest() {
        User user = userDao.getUser(1);
        user.setRole(Role.ADMIN);
        userDao.updateUser(user);
        Assert.assertEquals(userDao.getUser(1).getRole(), Role.ADMIN, "Role was successfully changed");
    }

    @Test
    public void listUsersTest() {
        Assert.assertNotNull(userDao.listUsers());
    }

    @Test
    public void findByNameTest() {
        Assert.assertNotNull(userDao.findByEmail("Linda123@gmail.com"), "There is user with email Linda123@gmail.com in test DB");
    }
    
    @Test
    public void findByEmailTest() {
        Assert.assertNotNull(userDao.findByName("Linda123"), "There is user with email Linda123@gmail.com in test DB");

    }
}
