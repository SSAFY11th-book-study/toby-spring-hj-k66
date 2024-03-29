package com.example.tobyspring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class DConnectionMaker implements ConnectionMaker{
    Map<String, String> env = System.getenv();
    @Override
    public Connection makeConnection() throws SQLException {
        return DriverManager.getConnection(env.get("DB_HOST"), env.get("DB_USER"), env.get("DB_PASSWORD"));
    }
}
