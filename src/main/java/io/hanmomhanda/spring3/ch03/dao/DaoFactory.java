package io.hanmomhanda.spring3.ch03.dao;

import org.h2.jdbcx.JdbcDataSource;

/**
 * Created by hanmomhanda on 2016-01-02.
 */
public class DaoFactory {
    private static UserDao userDao = new UserDao();
    private static JdbcContext jdbcContext = new JdbcContext();

    public static UserDao getUserDao() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:tcp://localhost/~/test");
        dataSource.setUser("sa");
        dataSource.setPassword("");

        jdbcContext.setDataSource(dataSource);

        userDao.setJdbcContext(jdbcContext);

        return userDao;
    }
}
