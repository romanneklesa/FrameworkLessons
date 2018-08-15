package com.frameworks.lessons.dao;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class AccountDaoTest extends EntityDaoImplTest {

    @Autowired
    AccountDao accountDao;


    @Override
    protected IDataSet getDataSet() throws Exception{

        IDataSet dataSet = new FlatXmlDataSet(new File("Account.xml"));
        return dataSet;
    }

    @Test
    public void findById(){
        Assert.assertNotNull(accountDao.getAccountsByUserId(1));
        Assert.assertTrue(accountDao.getAccountsByUserId(3).isEmpty());
    }


}