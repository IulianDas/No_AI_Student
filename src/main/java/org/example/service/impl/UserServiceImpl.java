package org.example.service.impl;

import org.example.entity.Role;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.AdminMenu;
import org.example.service.CourseMenu;
import org.example.service.UserService;
import org.example.util.Util;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CourseMenu courseMenu;
    private final AdminMenu adminMenu;
    private final Util resource;

    public UserServiceImpl(UserRepository userRepository, CourseMenu courseMenu, AdminMenu adminMenu, Util resource) {
        this.userRepository = userRepository;
        this.courseMenu = courseMenu;
        this.adminMenu = adminMenu;
        this.resource = resource;
    }

    @Override
    public void authentication() throws SQLException {
        User user;
        int position;
        String email, tempPassword;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce your Login Email: abc@mail.com");
        email = scanner.nextLine();
        position = userRepository.checkUser(email);
        if (position <= 0) {
            System.out.println("Wrong Email!");
        } else {
            user = userRepository.getUser(position);
            System.out.println("Introduce your Password! 12345");
            tempPassword = scanner.nextLine();
            if (tempPassword.equals(user.getPassword())) {

                try {
                    resource.loading();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (user.getRole().equals(Role.ADMIN)) {
                    System.out.println("Welcome Administrator!\n\n");
                    adminMenu.getAdminMenu(user.getId());
                } else {
                    System.out.println("Your are in, Welcome!\n\n");
                    courseMenu.getCourseMenu(user.getId());
                }
            } else {
                System.out.println("Wrong password!");
            }
        }

    }

    @Override
    public void registration() throws SQLException {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        boolean isEmail = true;
        String email = "";
        while (isEmail) {
            System.out.println("Introduce your Email: exam@mail.com");
            email = scanner.nextLine();
            if (email.equals("0")) {
                return;
            }
            int position = userRepository.checkUser(email);
            if (position == -1) {
                break;
            }
            System.out.println("This email is already used! input 0 to exit or try again!");

        }
        if (checkEmail(email)) {
            System.out.println("Introduce your Password: 8 digits and so on . . .");
            String tempPassword = scanner.nextLine();
            if (checkPassword(tempPassword)) {
                user.setEmail(email);
                user.setPassword(tempPassword);
                System.out.println("\n Select role: 1) User\t 2) Admin");
                int roleChoise = scanner.nextInt();
                if (roleChoise == 1) {
                    user.setRole(Role.USER);
                } else if (roleChoise == 2) {
                    user.setRole(Role.ADMIN);
                } else {
                    System.out.println("\n Wrong number! Default you are Loser!");
                    user.setRole(Role.USER);
                }
                userRepository.saveUsers(user);
                System.out.println("Registered successful!");
            } else {
                System.out.println("Wrong password format.");
            }
        } else {
            System.out.println("Wrong email format or email already exist.");
        }

    }

    private boolean checkEmail(String email) {
        String emailValidator = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern p = Pattern.compile(emailValidator);

        return email != null && p.matcher(email).matches();
    }

    private boolean checkPassword(String password) {
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
