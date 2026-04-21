package org.example.DB;

import java.sql.*;


public class DBConfig {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "NoAiStudents2026";

    public Connection getConnection () throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void closeConnection(Connection connection) throws SQLException{
        connection.close();
    }

}
