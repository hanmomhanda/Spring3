package io.hanmomhanda.spring3.ch03.dao;

import io.hanmomhanda.spring3.ch03.domain.User;
import lombok.Setter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hanmomhanda on 2016-01-02.
 */
public class UserDao {
    @Setter
    DataSource dataSource;

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = dataSource.getConnection();

            ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) {} }
            if (c != null) { try { c.close(); } catch (SQLException e) {} }
        }
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            c = dataSource.getConnection();

            ps = c.prepareStatement("select * from users where id = ?");
            ps.setString(1, id);

            rs = ps.executeQuery();

            rs.next();
            user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) {} }
            if (ps != null) { try { ps.close(); } catch (SQLException e) {} }
            if (c != null) { try { c.close(); } catch (SQLException e) {} }
        }

        return user;
    }

    public void delete(String id) throws ClassNotFoundException, SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = dataSource.getConnection();

            ps = c.prepareStatement("DELETE from users where id = ?");
            ps.setString(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) {} }
            if (c != null) { try { c.close(); } catch (SQLException e) {} }
        }
    }
}
