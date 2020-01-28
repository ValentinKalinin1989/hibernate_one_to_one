package com.luv2code.test_connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
        String user = "hdstudent";
        String pass = "hdstudent";

        try {
            System.out.println("Connection to database" + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection succesful!!!");
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }
}
