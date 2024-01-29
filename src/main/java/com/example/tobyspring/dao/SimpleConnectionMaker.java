package com.example.tobyspring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class SimpleConnectionMaker {

    Map<String, String> env = System.getenv();
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(env.get("DB_HOST"), env.get("DB_USER"), env.get("DB_PASSWORD"));
    }
}
