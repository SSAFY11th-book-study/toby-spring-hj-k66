package com.example.tobyspring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao{

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return DriverManager.getConnection(env.get("DB_HOST"), env.get("DB_USER"), env.get("DB_PASSWORD"));
    }
}
