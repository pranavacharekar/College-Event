/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perc;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class dbconn {
        public static Connection dbconnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mycar","root","");
            return con;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }
    }
}
