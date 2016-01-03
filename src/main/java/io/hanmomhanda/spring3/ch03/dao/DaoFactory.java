package io.hanmomhanda.spring3.ch03.dao;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by hanmomhanda on 2016-01-02.
 */
public class DaoFactory {
    private static UserDao userDao = new UserDao();
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public static UserDao getUserDao() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:tcp://localhost/~/test");
        dataSource.setUser("sa");
        dataSource.setPassword("");

        jdbcTemplate.setDataSource(dataSource);

        userDao.setJdbcTemplate(jdbcTemplate);

        return userDao;
    }
}
