package org.example.service;

import org.example.entity.Lesson;
import org.example.entity.UserProgress;

import java.sql.SQLException;

public interface UserProgressService {

    void updateUserProgress (UserProgress userProgress) throws SQLException;

}
