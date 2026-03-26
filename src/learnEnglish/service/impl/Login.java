package learnEnglish.service.impl;

import learnEnglish.entity.User;
import learnEnglish.repository.UserRepository;
import learnEnglish.resources.Resource;
import learnEnglish.service.AdminMenu;
import learnEnglish.service.LoginAccount;

import java.util.Scanner;

public class Login implements LoginAccount {


    public void login(UserRepository repository){

        learnEnglish.service.CourseMenu courseMenu = new learnEnglish.service.impl.CourseMenu();
        AdminMenu adminMenu = new learnEnglish.service.impl.AdminMenu();
        User user;
        Resource resource = new learnEnglish.resources.impl.Resource();
        int position;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce your Login Email:");
        String email= scanner.nextLine();
        position = repository.checkUser((learnEnglish.repository.impl.UserRepository) repository,email);

        if(position < 0){
            System.out.println("Wrong Email!");
        } else {
            user = repository.getUser(position);
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

}
