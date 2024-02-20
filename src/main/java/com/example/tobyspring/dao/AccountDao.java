package com.example.tobyspring.dao;

import javax.sql.DataSource;

public class AccountDao {
    private DataSource dataSource;

    public AccountDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

}
