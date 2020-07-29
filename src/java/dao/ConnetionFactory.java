/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class ConnetionFactory {
        Connection conn;

     public Connection getConn() {
        try {

            Class.forName("org.postgresql.Driver");
            String user = "postgres";
            String password = "postgres";
            String url = "jdbc:postgresql://localhost:5432/postgres";
            conn = (Connection) DriverManager.getConnection(url, user, password);

        }
        catch(SQLException e) {
            Logger.getLogger(ConnetionFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        catch(Exception e) {
            Logger.getLogger(ConnetionFactory.class.getName()).log(Level.SEVERE, null, e);
        }
       
        return conn;
    }
}
