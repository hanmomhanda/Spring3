package io.hanmomhanda.spring3.ch03.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by hanmomhanda on 2016-01-02.
 * @deprecated use DataSource instead
 */
@Deprecated
public interface ConnectionMaker {
    Connection getConnection() throws ClassNotFoundException, SQLException;
}
