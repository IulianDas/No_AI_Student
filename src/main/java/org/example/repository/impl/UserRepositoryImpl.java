package org.example.repository.impl;

import org.example.DB.DBConfig;
import org.example.entity.Role;
import org.example.entity.User;
import org.example.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl extends DBConfig implements UserRepository {

    private static Connection connection;

    public UserRepositoryImpl() throws SQLException {
        connection = super.getConnection();
    }

    @Override
    public List<User> getUsers() throws SQLException {
        List<User> usersList = new ArrayList<>();
        String query = "SELECT * FROM users;";
        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        User user = null;
        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt("user_id"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setRole(Role.valueOf(rs.getString("role")));
            usersList.add(user);
        }
        rs.close();
        stmt.close();
        return usersList;
    }

    @Override
    public User getUser(int userId) throws SQLException {
        String query = "SELECT * FROM users WHERE user_id = ?;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();
        User user = null;
        while (rs.next()) {
            user = new User();
            user.setId((int) rs.getLong("user_id"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setRole(Role.valueOf(rs.getString("role")));
        }
        rs.close();
        stmt.close();
        return user;
    }

    @Override
    public void saveUsers(User user) throws SQLException {
        String query = "INSERT INTO users (email, password, role) VALUES (?,?,?);";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, user.getEmail());
        stmt.setString(2, user.getPassword());
        stmt.setString(3, user.getRole().name());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public int checkUser(String email) throws SQLException {
        String query = "SELECT * FROM users WHERE email = ? ;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();

        if (!rs.next()) {
            rs.close();
            stmt.close();
            return -1;
        }
        int id = rs.getInt("user_id");
        rs.close();
        stmt.close();
        return id;
    }

}



