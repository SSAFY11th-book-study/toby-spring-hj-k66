package com.example.tobyspring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

public class JdbcContext {
    private DataSource dataSource;

    public JdbcContext (DataSource dataSource){
        this.dataSource = dataSource;
    }

    // 클라이언트
    public  void executeSql(String query) throws SQLException{
        workWithStatementStrategy(c -> c.prepareStatement(query));  //콜백 : 익명 내부 클래스
    }

    // 템플릿
    public void workWithStatementStrategy(StatementStrategy stmt) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = dataSource.getConnection();
            ps = stmt.makePreparedStatement(c);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {

                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {

                }
            }
        }
    }

}
