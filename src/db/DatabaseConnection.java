package db; // Sesuaikan dengan nama package Anda

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // URL database (sesuaikan dengan nama database Anda)
    private static final String URL = "jdbc:mysql://localhost:3306/penjualan_buku";
    private static final String USER = "root"; // Username database
    private static final String PASSWORD = ""; // Password database

    // Metode untuk mendapatkan koneksi
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

