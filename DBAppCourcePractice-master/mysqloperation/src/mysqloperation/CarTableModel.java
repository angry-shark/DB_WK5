/*
 * CarTableModel.java
 *
 * Created on 2005/01/17, 15:31
 */

package mysqloperation;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author noniko
 */
public class CarTableModel extends AbstractTableModel {
    
    private int colnum=4;
    private int rownum;
    private String[] colNames={
        "ID","Name","Vendor","Type"
    };
    private  ArrayList<String[]> ResultSets;
    
    /** Creates a new instance of FoodTableModel */
    public CarTableModel(ResultSet rs) {
      
      ResultSets=new ArrayList<String[]>();  
    
      try{
        while(rs.next()){
      
              String[] row={
                rs.getString("carid"),rs.getString("name"), rs.getString("vendor"),rs.getString("type")
          
            };
            ResultSets.add(row);
      
         }   
      }
      catch(Exception e){
          System.out.println("Exception in CarTableModel");
            }
        
    }
   
    public Object getValueAt(int rowindex, int columnindex) {
        
       String[] row=ResultSets.get(rowindex);
       return row[columnindex];
        
    }

    public int getRowCount() {
        return ResultSets.size();
    }

    public int getColumnCount() {
        return colnum;
    }

    public String getColumnName(int param) {

       return colNames[param];
    }
    
}
