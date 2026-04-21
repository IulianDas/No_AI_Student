package org.example.repository;

import org.example.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {

    User getUser(int id) throws SQLException;
    List<User> getUsers() throws SQLException;
    void saveUsers(User user) throws SQLException;
    int checkUser( String email) throws SQLException;
}
