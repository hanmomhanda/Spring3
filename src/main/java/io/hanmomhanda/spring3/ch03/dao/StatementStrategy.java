package io.hanmomhanda.spring3.ch03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by hanmomhanda on 2016-01-03.
 */
public interface StatementStrategy {
    PreparedStatement prepareStatement(Connection c) throws SQLException;
}
