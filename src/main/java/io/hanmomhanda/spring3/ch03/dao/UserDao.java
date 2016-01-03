package io.hanmomhanda.spring3.ch03.dao;

import io.hanmomhanda.spring3.ch03.domain.User;
import lombok.Setter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by hanmomhanda on 2016-01-02.
 */
public class UserDao {
    @Setter
    JdbcContext jdbcContext;

    public void add(final User user) throws ClassNotFoundException, SQLException {
        jdbcContext.processStatement(new StatementStrategy() {
            @Override
            public PreparedStatement prepareStatement(Connection c) throws SQLException {
                PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
                ps.setString(1, user.getId());
                ps.setString(2, user.getName());
                ps.setString(3, user.getPassword());
                return ps;
            }
        });
    }

    public User get(final String id) throws ClassNotFoundException, SQLException {
        Map<String, Object> rowMap = jdbcContext.queryForObject(new StatementStrategy() {
            @Override
            public PreparedStatement prepareStatement(Connection c) throws SQLException {
                PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
                ps.setString(1, id);
                return ps;
            }
        });

        User user = new User();
        user.setId((String)rowMap.get("id"));
        user.setName((String)rowMap.get("name"));
        user.setPassword((String)rowMap.get("password"));

        return user;
    }

    public void delete(final String id) throws ClassNotFoundException, SQLException {
        jdbcContext.processStatement(c -> {
            PreparedStatement ps = c.prepareStatement("DELETE from users where id = ?");
            ps.setString(1, id);
            return ps;
        });
    }
}
