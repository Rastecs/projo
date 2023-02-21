package com.example.projo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaselink;

    public Connection getConnection(){
        String databasename = "sys";
        String databaseuser = "root";
        String databasepassword = "Jondai01";
        String url = "jdbc:mysql://localhost/" + databasename;


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink = DriverManager.getConnection(url,databaseuser,databasepassword);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaselink;
    }
}
