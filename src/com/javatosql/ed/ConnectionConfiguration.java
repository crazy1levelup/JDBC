package com.javatosql.ed;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfiguration {

    public static Connection getConnection() {
        Connection connection = null;
        UserName username = new UserName();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseNAME=Animale;integratedsecurity=true", username.getUserName(), "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
