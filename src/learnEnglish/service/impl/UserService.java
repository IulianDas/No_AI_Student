package learnEnglish.service.impl;

import learnEnglish.repository.UserRepository;
import learnEnglish.service.LoginAccount;
import learnEnglish.service.Registration;

public class UserService implements learnEnglish.service.UserService {

    public void userService(){

    }
    @Override
    public void authentication(UserRepository repository) {
        LoginAccount authentication = new Login();
        authentication.login(repository);
    }

    @Override
    public void registration(UserRepository repository) {
        Registration registration = new learnEnglish.service.impl.Registration();
        registration.registerUser(repository);

    }
}
