package com.example.tobyspring.dao;

import com.example.tobyspring.domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class UserDao {
    private DataSource dataSource;

    public UserDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void deleteAll() throws SQLException{
        Connection c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement("delete from users");
        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public int getCount() throws SQLException{
        Connection c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement("select count(*) from users");

        ResultSet rs = ps.executeQuery();
        rs.next();
        int count = rs.getInt(1);

        rs.close();
        ps.close();
        c.close();

        return count;
    }
    public void add(User user) throws SQLException {
        //1. DB 연결을 위한 Connection 가져온다.
        Connection c = dataSource.getConnection();

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

    public User get(String id) throws SQLException {
        //1. DB 연결을 위한 Connection 가져온다.
        Connection c = dataSource.getConnection();

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
}
