package com.duplicall.main;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Created by raymond on 2016/2/14.
 */
public class InitOracle {
    public static final String URL = "jdbc:mysql://192.168.2.134:3306/ngp";
    public static final String NAME = "com.mysql.jdbc.Driver";
    public static final String USER = "ngp";
    public static final String PASSWORD = "password";
    public volatile Connection connection;
    Logger logger = Logger.getLogger("InitOracle");

    public void produceConnection() throws ClassNotFoundException, SQLException {
        PreparedStatement pst = null;
        Class.forName(NAME);
        connection = DriverManager.getConnection(URL, USER, PASSWORD);

    }

    static void init() {
        File disk = new File("C:/");
        if (!disk.exists()) {
            disk = new File("D:/");
        }
        System.out.println(disk.exists());
    }

    public static void main(String[] args) {
        init();

    }
}
