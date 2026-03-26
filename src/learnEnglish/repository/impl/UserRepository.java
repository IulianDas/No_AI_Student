package learnEnglish.repository.impl;

import learnEnglish.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements learnEnglish.repository.UserRepository {

    private static final User admin = new User(0,"admin","admin");
    private static List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(admin);
    }

    public int getSize() {
        return users.size();
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
    public int checkUser(UserRepository repository, String email) {
        int position = 0;
        for (int i = 0; i <= repository.getSize()-1; i++) {
            if (repository.getUser(i).getEmail().equals(email)) {
                position = i;
            }
        }
        if(position >=0){
            return position;
        }
        else {
            return -1;
        }
    }
}



