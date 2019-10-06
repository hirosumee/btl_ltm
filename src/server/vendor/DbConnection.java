/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.vendor;

import java.sql.*;

/**
 * @author hirosume
 */
public class DbConnection {
    private static String
            connectionUrl =
            "jdbc:sqlserver://localhost:1433;databaseName=new_database;user=SA;password=P@ssw0rd";


    private static DbConnection instance;
    private Connection con;

    private DbConnection() throws SQLException {
        con = DriverManager.getConnection(connectionUrl);
    }

    public static DbConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return con;
    }
}
