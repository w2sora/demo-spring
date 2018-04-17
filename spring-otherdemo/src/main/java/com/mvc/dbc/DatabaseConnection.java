package com.mvc.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://192.168.100.2:3306/spring?useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    private Connection conn;

    public DatabaseConnection() throws Exception {
        Class.forName(DB_DRIVER);
        this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void close() throws Exception {
        if (this.conn != null) {
            this.conn.close();
        }
    }

}
