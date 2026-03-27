package learnEnglish.repository;

import learnEnglish.entity.User;
import learnEnglish.repository.impl.UserRepositoryImpl;

import java.util.List;

public interface UserRepository {

    User getUser(int id);
    List<User> getUsers();
    void setUsers(User user);
    int checkUser(UserRepositoryImpl repository, String email);
}
