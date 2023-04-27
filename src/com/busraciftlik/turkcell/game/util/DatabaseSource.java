package com.busraciftlik.turkcell.game.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSource {
    public static final String URL = "jdbc:postgresql://localhost:5432/game-platform";
    public static final String USER = "postgres";
    public static final String PASSWORD = "12345";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
