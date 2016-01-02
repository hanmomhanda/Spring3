package io.hanmomhanda.spring3.ch01.dao;

/**
 * Created by hanmomhanda on 2016-01-02.
 */
public class DaoFactory {
    private static UserDao userDao = new UserDao();

    public static UserDao getUserDao() {
        return userDao;
    }
}
