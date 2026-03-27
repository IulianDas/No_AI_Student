import learnEnglish.repository.UserRepository;
import learnEnglish.repository.impl.UserRepositoryImpl;
import learnEnglish.resources.Resource;
import learnEnglish.resources.impl.ResourceImpl;
import learnEnglish.service.AdminMenu;
import learnEnglish.service.CourseMenu;
import learnEnglish.service.UserService;
import learnEnglish.service.impl.AdminMenuImpl;
import learnEnglish.service.impl.CourseMenuImpl;
import learnEnglish.service.impl.UserServiceImpl;

import java.util.Scanner;

public class Main {

    private static final UserRepository userRepository = new UserRepositoryImpl();
    private static final CourseMenu courseMenu = new CourseMenuImpl();
    private static final AdminMenu adminMenu = new AdminMenuImpl();
    private static final Resource resource = new ResourceImpl();
    private static final UserService userService = new UserServiceImpl(userRepository, courseMenu, adminMenu,resource);

    public static void main(String[] args) {

        //ToDO Eto esheo siroi proekt

        boolean tokenMenu = true;

        while (tokenMenu){
        System.out.print("\n--------- English Lesson -----------\n"
                +"\t\n"
                +"\t\t1) Login\n"
                +"\t\t2) Register\n"
                +"\t\t0) Exit\n"
                +"\n------------------------------------\n");

            Scanner menu = new Scanner(System.in);
            int menuChoise = menu.nextInt();
            switch (menuChoise) {
                case 1:
                    userService.authentication();
                    break;
                case 2:
                    userService.registration();
                    break;
                case 0:
                    tokenMenu = false;
                    break;
            }



        /*SyntaxMenu syntaxMenu = new SyntaxMenu();
        OOP oopMenu = new OOP();
        boolean tokenMenu = true;

        while (tokenMenu){
            System.out.print("\n------------ Main Menu -------------\n" +
                    "\tChose exercise to test:\n" +
                    "\t\t1) Exercise One with Java Syntax\n" +
                    "\t\t2) Exercise Two with OOP Principles\n" +
                    "\t\t0) Exit" +
                    "\n------------------------------------\n");

            Scanner menu = new Scanner(System.in);
            int menuChoise = menu.nextInt();

            switch (menuChoise) {
                case 1:
                    syntaxMenu.syntaxMenu();
                    break;
                case 2:
                    oopMenu.oopMenu();
                    break;
                case 0:
                    tokenMenu = false;
                    break;
            }
        }*/

    }
    }

}