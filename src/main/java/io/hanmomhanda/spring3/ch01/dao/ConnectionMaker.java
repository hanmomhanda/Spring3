package io.hanmomhanda.spring3.ch01.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by hanmomhanda on 2016-01-02.
 */
public interface ConnectionMaker {
    Connection getConnection() throws ClassNotFoundException, SQLException;
}
