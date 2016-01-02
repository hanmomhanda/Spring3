package io.hanmomhanda.spring3.ch01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by hanmomhanda on 2016-01-02.
 */
public class ConnectionMakerImpl implements ConnectionMaker {
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }
}
