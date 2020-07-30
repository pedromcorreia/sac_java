/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author pedro
 */
public class LoginDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public LoginDAO(){
        conn = new ConnetionFactory().getConn();
    }

    public boolean login(User user) {
        Integer total_users = 0;
        try {
            
            String sql = "SELECT count(*) as users FROM public.user where login = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            if( rs.next() ){
                total_users = rs.getInt("users" );
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return total_users == 1;
    }
}
