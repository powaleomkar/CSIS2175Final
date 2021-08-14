package com.company;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Connection1 {

    public Connection connect() throws ClassNotFoundException, SQLException {
        //jdbc configuration for url
        Class.forName("com.mysql.jdbc.Driver");
        //establish connection to database. URL is specified in  getConnection method as 1st parameter.
        java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/savings", "root", "");
        return con1;
    }
}
