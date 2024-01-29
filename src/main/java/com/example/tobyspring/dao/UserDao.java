package com.example.tobyspring.dao;

import com.example.tobyspring.domain.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public abstract class UserDao {
    Map<String, String> env = System.getenv();
    public void add(User user) throws ClassNotFoundException, SQLException {
        //1. DB 연결을 위한 Connection 가져온다.
        Connection c = getConnection();

        //2. SQL을 담은 Statement를 만든다.
        PreparedStatement ps = c.prepareStatement(
                "insert into users(id,name,password) values(?,?,?)"
        );
        ps.setString(1,user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        //3. 만들어진 Statement를 실행
        ps.executeUpdate();

        //4. 작업 중 생성된 Connection, Statement 등 리소스는 작업을 마친 후 반드시 닫는다.
        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        //1. DB 연결을 위한 Connection 가져온다.
        Connection c = getConnection();

        //2. SQL을 담은 Statement를 만든다.
        PreparedStatement ps = c.prepareStatement(
                "select * from users where id = ?"
        );
        ps.setString(1,id);

        //3. 만들어진 statement를 실행
        //4. 조회의 경우, SQL 쿼리 실행 결과를 ResultSet으로 받아서 정보를 저장할 오브젝트(user)에 옮겨준다.
        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        //5. 작업 중 생성된 Connection, Statement 등 리소스는 작업을 마친 후 반드시 닫는다.
        rs.close();
        ps.close();
        c.close();

        return user;
    }

    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
}
