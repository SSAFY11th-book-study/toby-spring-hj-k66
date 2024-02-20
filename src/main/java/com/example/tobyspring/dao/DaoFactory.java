package com.example.tobyspring.dao;

import java.sql.Driver;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class DaoFactory {

    Map<String, String> env = System.getenv();

    @Bean
    public UserDao userDao(){
        return new UserDao(dataSource());
    }

    @Bean
    public AccountDao accountDao(){
        System.out.println("call accountDao()");
        AccountDao accountDao = new AccountDao(dataSource());
        return accountDao;
    }


    private DataSource dataSource(){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(Driver.class);
        dataSource.setUrl(env.get("DB_HOST"));
        dataSource.setUsername(env.get("DB_USER"));
        dataSource.setPassword(env.get("DB_PASSWORD"));
        return dataSource;
    }

}
