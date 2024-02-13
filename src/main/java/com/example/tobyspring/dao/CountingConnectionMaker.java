package com.example.tobyspring.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class CountingConnectionMaker implements ConnectionMaker{
    int counter = 0;
    private ConnectionMaker realConnectionMaker;

    public CountingConnectionMaker(ConnectionMaker connectionMaker){
        this.realConnectionMaker = connectionMaker;
    }

    @Override
    public Connection makeConnection() throws SQLException {
        this.counter++;
        return realConnectionMaker.makeConnection();
    }

    public int getCounter(){
        return counter;
    }
}
