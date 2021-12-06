/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equity_management;

import com.sun.jdi.connect.spi.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Shardul Gawande
 */
public class DBConnection {
    
    public static Connection getConnection(){
//        Connection con = null;
        
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Equity_management","root","root");
            
        }catch(Exception e){
           
            
            e.printStackTrace();
        }
        Connection con = null;
        
        return con;
    }
}
