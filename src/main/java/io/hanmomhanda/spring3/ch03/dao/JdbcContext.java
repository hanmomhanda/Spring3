package io.hanmomhanda.spring3.ch03.dao;

import lombok.Setter;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hanmomhanda on 2016-01-03.
 */
public class JdbcContext {
    @Setter
    DataSource dataSource;

    public void update(final String query, final String... args) throws SQLException {
        processStatement(createStatementStrategy(query, args));
    }

    public Map<String, Object> retrieve(final String query, final String... args) throws SQLException {
        return queryForObject(createStatementStrategy(query, args));
    }

    private StatementStrategy createStatementStrategy(final String query, final String... args) throws SQLException {
        return c -> {
            PreparedStatement ps = c.prepareStatement(query);
            int i, len;
            for (i = 1, len = args.length ; i <= len ;i++) {
                ps.setString(i, args[i-1]);
            }
            return ps;
        };
    }

    private void processStatement(StatementStrategy strategy) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = dataSource.getConnection();

            ps = strategy.prepareStatement(c);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) {} }
            if (c != null) { try { c.close(); } catch (SQLException e) {} }
        }
    }

    private Map<String, Object> queryForObject(StatementStrategy strategy) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String, Object> rowMap = new HashMap<>();

        try {
            c = dataSource.getConnection();

            ps = strategy.prepareStatement(c);

            rs = ps.executeQuery();

            ResultSetMetaData rsmeta = rs.getMetaData();
            int i, columnCount = rsmeta.getColumnCount();

            while(rs.next()) {
                for (i = 1 ; i <= columnCount ; i++) {
                    rowMap.put(rsmeta.getColumnName(i).toLowerCase(), rs.getObject(i));
                }
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) {} }
            if (ps != null) { try { ps.close(); } catch (SQLException e) {} }
            if (c != null) { try { c.close(); } catch (SQLException e) {} }
        }
        return rowMap;
    }
}
