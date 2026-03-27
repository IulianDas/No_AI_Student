package learnEnglish.service.impl;

import learnEnglish.entity.User;
import learnEnglish.repository.UserRepository;
import learnEnglish.repository.impl.UserRepositoryImpl;
import learnEnglish.resources.Resource;
import learnEnglish.service.AdminMenu;
import learnEnglish.service.CourseMenu;
import learnEnglish.service.UserService;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CourseMenu courseMenu;
    private final AdminMenu adminMenu;
    private final Resource resource;

    public UserServiceImpl(UserRepository userRepository, CourseMenu courseMenu, AdminMenu adminMenu, Resource resource) {
        this.userRepository = userRepository;
        this.courseMenu = courseMenu;
        this.adminMenu = adminMenu;
        this.resource = resource;
    }

    @Override
    public void authentication() {

        User user;
        int position;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce your Login Email:");
        String email= scanner.nextLine();
        position = userRepository.checkUser((UserRepositoryImpl) userRepository,email);

        if(position < 0){
            System.out.println("Wrong Email!");
        } else {
            user = userRepository.getUser(position);
            System.out.println("Introduce your Password!");
            String tempPassword= scanner.nextLine();
            if (tempPassword.equals(user.getPassword())){

                try {
                    resource.loading();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (tempPassword.equals(email) && email.equals("admin")){
                    System.out.println("Welcome Administrator!\n\n");
                    adminMenu.getAdminMenu(user);
                } else {
                    System.out.println("Your are in, Welcome!\n\n");
                    courseMenu.getCourseMenu(user);
                }
            } else {
                System.out.println("Wrong password!");
            }
        }

    }

    @Override
    public void registration() {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce your Email: example@mail.com");
        String email= scanner.nextLine();
        if (checkEmail(email)){
            System.out.println("Introduce your Password: example@mail.com");
            String tempPassword= scanner.nextLine();
            if (checkPassword(tempPassword)){
                user.setId(40);
                user.setEmail(email);
                user.setPassword(tempPassword);
                userRepository.setUsers(user);
                System.out.println("Registered successful!");
            }else{
                System.out.println("Wrong password format.");
            }
        } else{
            System.out.println("Wrong email format or email already exist.");
        }

    }

    private boolean checkEmail(String email){
        String emailValidator = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern p = Pattern.compile(emailValidator);

        return email != null && p.matcher(email).matches();
    }

    private boolean checkPassword(String password){
      /*  String regex = "^(?=.*[0-9])"
        + "(?=.*[a-z])(?=.*[A-Z])"
        + "(?=.*[@#$%^&amp;+=])"
        + "(?=\\S+$).{8,20}";

        Pattern p = Pattern.compile(regex);

        if (password == null) {
            return false;
        }
        Matcher m = p.matcher(password);
        return m.matches();*/
        return true;

    }
}
