package org.example.service;

import java.sql.SQLException;

public interface UserService {
    void authentication() throws SQLException;
    void registration() throws SQLException;

}
