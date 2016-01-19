package io.hanmomhanda.spring3.ch03.dao;

import io.hanmomhanda.spring3.ch03.domain.User;
import lombok.Setter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hanmomhanda on 2016-01-02.
 */
public class UserDao {
    @Setter
    JdbcTemplate jdbcTemplate;

    public void add(final User user) {
        jdbcTemplate.update("insert into users(id, name, password) values(?,?,?)",
                user.getId(), user.getName(), user.getPassword());
    }

    public User get(final String id) {
        return jdbcTemplate.queryForObject("select * from users where id = ?",
                new Object[]{id},
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int i) throws SQLException {
                        User user = new User();
                        user.setId(rs.getString("id"));
                        user.setName(rs.getString("name"));
                        user.setPassword(rs.getString("password"));

                        return user;
                    }
                });
    }

    public void delete(final String id) {
        jdbcTemplate.update("DELETE from users where id = ?", id);
    }
}
