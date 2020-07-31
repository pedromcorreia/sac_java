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
import java.sql.Statement;
import java.util.ArrayList;
import model.Question;
import model.User;

/**
 *
 * @author pedro
 */
public class QuestionDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private PreparedStatement ps;

    private ResultSet rs;
    private ArrayList<Question> question_list = new ArrayList<>();

    public QuestionDAO() {
        conn = new ConnetionFactory().getConn();
    }

    public void create(Question question) {
        String sql = "INSERT INTO public.user (user_id, product_id, type, description, active) VALUES (?,?,?,?, true)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, question.getUser_id());
            stmt.setInt(2, question.getProduct_id());
            stmt.setString(3, question.getType());
            stmt.setString(4, question.getDescription());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Question question) {
        String sql = "UPDATE user set name = ? WHERE id = ?";
//        try {
//            stmt = conn.prepareStatement(sql);
//            stmt.setString(1, user.getName());
//            stmt.setInt(2, user.getId());
//            stmt.execute();
//            stmt.close();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

    public ArrayList<Question> all(User user) {
        String sql = "SELECT * FROM question where user_id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setQuestion_id(rs.getInt("question_id"));
                question.setProduct_id(rs.getInt("product_id"));
                question.setActive(rs.getBoolean("active"));
                question.setType(rs.getString("type"));
                question.setDescription(rs.getString("description"));
                question.setSolution(rs.getString("solution"));
                question.setSolution(rs.getString("solution"));

                question_list.add(question);
            }
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return question_list;
    }
}
