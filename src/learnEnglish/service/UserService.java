package learnEnglish.service;

import learnEnglish.repository.UserRepository;

public interface UserService {
    void authentication(UserRepository repository);
    void registration(UserRepository repository);

}
