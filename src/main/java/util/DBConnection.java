package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://mysql-25a01587-ofentsesherifflebani-6e7c.c.aivencloud.com:26986/ai_solutions?sslMode=REQUIRED";

    private static final String USER = "avnadmin";

    // SECURE: read from environment variable
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() {

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}