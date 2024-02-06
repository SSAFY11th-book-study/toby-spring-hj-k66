package com.example.tobyspring.dao;

public class DaoFactory {
    public UserDao userDao(){
        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }

    public AccountDao accountDao(){
        AccountDao accountDao = new AccountDao(connectionMaker());
        return accountDao;
    }

    public ConnectionMaker connectionMaker(){
        return new DConnectionMaker();
    }
}
