package com.example.tobyspring.dao;

import com.example.tobyspring.domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStatement implements StatementStrategy {
    User user;

    public AddStatement(User user){
        this.user = user;
    }
    @Override
    public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
        //2. SQL을 담은 Statement를 만든다.
        PreparedStatement ps = c.prepareStatement(
                "insert into users(id,name,password) values(?,?,?)"
        );
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        return ps;

    }
}
