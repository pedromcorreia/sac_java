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
import model.UserModel;

/**
 *
 * @author pedro
 */
public class LoginDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public LoginDAO() {
        conn = new ConnetionFactory().getConn();
    }

    public UserModel login(UserModel user) {
        UserModel result_user = new UserModel();
        try {

            String sql = "SELECT * FROM public.user where email = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
                result_user.setId(rs.getInt("user_id"));
                result_user.setName(rs.getString("name"));
                result_user.setEmail(rs.getString("email"));
                result_user.setRole(rs.getString("role"));
                result_user.setCpf(rs.getString("cpf"));
                result_user.setPhone(rs.getString("phone"));
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result_user;
    }
}
