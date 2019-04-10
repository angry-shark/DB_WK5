/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a106-24
 */
public class Main {
    private  static Statement statement;
    private static Connection connection;
    private  static  ResultSet resultSet;
    
   public Main() throws SQLException{
        DBConnection conn = new DBConnection();
        conn.init();
        this.connection = conn.getMyConnection();
        //  jTextArea1.setText("Connect DB successfully!!");
        //  System.out.println("Connect DB successfully!!");
        String query = "select * from cars";
        this.statement = this.connection.createStatement();
        this.resultSet = this.statement.executeQuery(query);
    }
    
    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
        
       /* try{
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/caixukun","root", ""
                );
        String query = "select * from cars";
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
        System.out.println(resultSet);
        while(resultSet.next()){
            System.out.println("id: " + resultSet.getString("carid") + " name: " + resultSet.getString("name"));
        }
        }
        catch(Exception e){
            System.out.println("Failed to get connection");
            e.printStackTrace();
        };
        */
        
        
        Main instance = new Main();
        while (instance.resultSet.next()) { 
            System.out.println("AAA");
            String carid = instance.resultSet.getString("carid");
            String carname = instance.resultSet.getString("name");
            System.out.println("id " + carid + " name: " + carname);        
        }
    }
}

