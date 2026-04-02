package learnEnglish.repository.impl;

import learnEnglish.entity.Role;
import learnEnglish.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements learnEnglish.repository.UserRepository {

    private final List<User> users = new ArrayList<>();

    public UserRepositoryImpl() {
        users.add(new User(0,"admin","admin", Role.ADMIN));
        users.add(new User(0,"exam@mail.com","123", Role.USER));
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
    @Override
    public User getUser(int id) {
        return users.get(id);
    }

    @Override
    public void setUsers(User user) {
        users.add(user);
    }

    @Override
    public int checkUser(String email) {
        for (int i = 0; i <= users.size()-1; i++) {
            if (users.get(i).getEmail().equals(email)) {
                return i;
            }
        }return -1;
        }

}



