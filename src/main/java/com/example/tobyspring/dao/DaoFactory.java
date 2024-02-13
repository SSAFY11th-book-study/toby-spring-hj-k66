package com.example.tobyspring.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao(){
        System.out.println("call userDao()");
        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }

    @Bean
    public UserDao userDao(ConnectionMaker connectionMaker){
        return new UserDao(connectionMaker);
    }

    @Bean
    public AccountDao accountDao(){
        System.out.println("call accountDao()");
        AccountDao accountDao = new AccountDao(connectionMaker());
        return accountDao;
    }


    @Bean
    public ConnectionMaker connectionMaker(){
        System.out.println("call connectionMaker()");
        return new DConnectionMaker();
    }
}
