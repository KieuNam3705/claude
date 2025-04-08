/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author phanh
 */

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/tourmanagement"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "150505"; 

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối thành công!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Kết nối thất bại!");
        }
        return conn;
    }

    public static void main(String[] args) {
        getConnection(); // Kiểm tra kết nối
    }
}


