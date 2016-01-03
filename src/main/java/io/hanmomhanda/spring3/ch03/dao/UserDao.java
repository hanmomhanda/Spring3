package io.hanmomhanda.spring3.ch03.dao;

import io.hanmomhanda.spring3.ch03.domain.User;
import lombok.Setter;

import java.sql.SQLException;
import java.util.Map;

/**
 * Created by hanmomhanda on 2016-01-02.
 */
public class UserDao {
    @Setter
    JdbcContext jdbcContext;

    public void add(final User user) throws ClassNotFoundException, SQLException {
        jdbcContext.update("insert into users(id, name, password) values(?,?,?)",
                user.getId(), user.getName(), user.getPassword());
    }

    public User get(final String id) throws ClassNotFoundException, SQLException {
        Map<String, Object> rowMap = jdbcContext.retrieve("select * from users where id = ?", id);

        User user = new User();
        user.setId((String)rowMap.get("id"));
        user.setName((String)rowMap.get("name"));
        user.setPassword((String)rowMap.get("password"));

        return user;
    }

    public void delete(final String id) throws ClassNotFoundException, SQLException {
        jdbcContext.update("DELETE from users where id = ?", id);
    }
}
