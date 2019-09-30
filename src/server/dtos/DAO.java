package server.dtos;

import server.vendor.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;

abstract class DAO {
    String table;
    Connection connection;

    {
        try {
            connection = DbConnection.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    String injectTableName(String str) {
        return String.format(str, table);
    }
}
