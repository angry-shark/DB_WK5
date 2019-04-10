/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a106-24
 */
public class utils {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private void GetODEsBlob(String dbtablename,int i, int iCompLib) {
        try {            
            Class.forName("org.gjt.mm.mysql.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TDBNR_DB?user=root&password=");
            //  jTextArea1.setText("Connect DB successfully!!");
            //  System.out.println("Connect DB successfully!!");
            String query_ODEsBlob = "SELECT * FROM "+dbtablename+" WHERE RandomNum =" + i + " AND IterationNum =" + iCompLib + " ;";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query_ODEsBlob);
            if (resultSet.next()) {                
                Blob ODEsBlob=resultSet.getBlob(9);
                InputStream x=ODEsBlob.getBinaryStream();
                int size=x.available();
                String filepath = "/Users/zujianwu/NetBeansProjects/TDBNR/wutempfile/GenerateODEs.txt";
                OutputStream out=new FileOutputStream(filepath);
                byte b[]= new byte[size];
                x.read(b);
                out.write(b);                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(TDBNRView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TDBNRView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TDBNRView.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                statement.close();
                connection.close();
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
