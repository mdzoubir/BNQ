package com.example.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
        static String url = "jdbc:postgresql://localhost:5432/banque";
        static String utilisateur = "postgres";
        static String password = "simo012simo";
        static Connection connection = null;


        public static Connection getMyConnexion() throws ClassNotFoundException, SQLException {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, utilisateur, password);
            return connection;
        }
}
