package io.hanmomhanda.spring3.ch03.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by hanmomhanda on 2016-01-02.
 * @deprecated use DataSource instead
 */
@Deprecated
public class ConnectionMakerImpl implements ConnectionMaker {
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }
}
