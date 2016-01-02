package io.hanmomhanda.spring3.ch01.dao;

import io.hanmomhanda.spring3.ch01.domain.User;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hanmomhanda on 2016-01-02.
 */
public class UserDao {
    @Setter
    ConnectionMaker connectionMaker;

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.getConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }


    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.getConnection();

        PreparedStatement ps = c
                .prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

    public void delete(String id) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.getConnection();

        PreparedStatement ps = c
                .prepareStatement("DELETE from users where id = ?");
        ps.setString(1, id);

        ps.executeUpdate();

        ps.close();
        c.close();
    }
}
