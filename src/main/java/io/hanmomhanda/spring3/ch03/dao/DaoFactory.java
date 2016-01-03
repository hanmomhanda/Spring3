package io.hanmomhanda.spring3.ch03.dao;

import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;

/**
 * Created by hanmomhanda on 2016-01-02.
 */
public class DaoFactory {
    private static UserDao userDao = new UserDao();

    public static UserDao getUserDao() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:tcp://localhost/~/test");
        dataSource.setUser("sa");
        dataSource.setPassword("");
        userDao.setDataSource(dataSource);
        return userDao;
    }
}
