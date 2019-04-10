/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import java.sql.*;

/**
 *
 * @author a106-24
 */
public class DBConnection {
   
    private Connection myConnection;
    
    /** Creates a new instance of MyDBConnection */
    public DBConnection() {

    }

    public void init(){
    
       try{
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        myConnection=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/caixukun","root", ""
                );
        }
        catch(Exception e){
            System.out.println("Failed to get connection");
            e.printStackTrace();
        };
    }
    
    
    public Connection getMyConnection(){
        return myConnection;
    }
    
    
    public void close(ResultSet rs){
        
        if(rs !=null){
            try{
               rs.close();
            }
            catch(Exception e){}
        
        }
    }
    
     public void close(java.sql.Statement stmt){
        
        if(stmt !=null){
            try{
               stmt.close();
            }
            catch(Exception e){}
        
        }
    }
     
  public void destroy(){
  
    if(myConnection !=null){
    
         try{
               myConnection.close();
            }
            catch(Exception e){}
        
        
    }
  }
    
}

