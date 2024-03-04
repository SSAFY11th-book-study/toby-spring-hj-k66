package com.example.tobyspring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

public class UserDaoDeleteAll extends UserDao{

    public UserDaoDeleteAll(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected PreparedStatement makeStatement(Connection c) throws SQLException {
        PreparedStatement ps = c.prepareStatement("delete from users");
        return ps;
    }
}
