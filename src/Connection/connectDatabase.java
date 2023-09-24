/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author TriHieu
 */
public class connectDatabase {
   public Connection getConnection() throws ClassNotFoundException{
        Connection conn = null;
        try {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=GROUP4";
            String user = "sa";
            String pass = "123";
            conn = DriverManager.getConnection(url, user, pass);
            if(conn != null)
                System.out.println("Ket noi thanh cong");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return conn;
    }
}
