package integrationTests.com.frameworks.lessons.dao;

import com.frameworks.lessons.entity.Account;
import com.frameworks.lessons.entity.User;
import org.hibernate.ObjectNotFoundException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountDaoImplTest extends EntityDaoImplTest {

    @Test
    public void addTest() {
        User user = userDao.getUser(1);
        Account account = new Account();
        account.setId(3);
        account.setAmount(999);
        account.setUser(user);

        Assert.assertFalse(accountDao.getAccountsByUserId(1).contains(account), "Account is not added yet");
        accountDao.add(account);
        Assert.assertTrue(accountDao.getAccountsByUserId(1).contains(account), "Account is successfully added");
    }

    @Test(expectedExceptions = ObjectNotFoundException.class)
    public void getAccountExeptionTest() {
        accountDao.getAccount(10);
    }

    @Test
    public void getTest() {
        Assert.assertEquals(accountDao.getAccount(1).getId(), 1, "Account successfully read from db and it's id is as expected");
    }

    @Test
    public void deleteAccountTest() {
        Assert.assertEquals(accountDao.getAccountsByUserId(1).size(), 2, "There are 2 accounts with user id 1");
        accountDao.deleteAccount(1);
        Assert.assertEquals(accountDao.getAccountsByUserId(1).size(), 1, "There is 1 accounts with user id 1 left");
    }

    @Test
    public void updateAccountTest() {
        Account account = accountDao.getAccount(1);
        account.setAmount(333);
        accountDao.updateAccount(account);
        Assert.assertEquals(accountDao.getAccount(1).getAmount(), 333, "Account ammount is successfully updated");
    }

    @Test
    public void getAccountsByUserIdTest() {
        Assert.assertNotNull(accountDao.getAccountsByUserId(1));
        Assert.assertTrue(accountDao.getAccountsByUserId(3).isEmpty());
    }
}