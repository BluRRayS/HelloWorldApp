package com.blurrays.myjobappdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DatabaseConnection {

    public static Connection getConnection() {
        Connection connection = null;
        try {

            // Load the NetDirect JDBC driver

            String driverName = "com.jnetdirect.jsql.JSQLDriver";

            Class.forName(driverName);


            // Create a connection to the database

            String serverName = "(LocalDB)\\MSSQLLocalDB";

            String serverPort = "1433";

            String database = serverName + ":" + serverPort;

            String url = "jdbc:JSQLConnect://" + database;

            String username = "LAPTOP-G44V1OIO\\BluRRayS";

            String password = "";

            connection = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {

            System.out.println("Could not find the database driver " + e.getMessage());
        } catch (SQLException e) {

            System.out.println("Could not connect to the database " + e.getMessage());
        }
        return connection;
    }
}
