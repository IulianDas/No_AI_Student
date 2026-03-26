import learnEnglish.repository.UserRepository;
import learnEnglish.service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //ToDO Eto esheo siroi proekt


        boolean tokenMenu = true;
        UserRepository userRepository = new learnEnglish.repository.impl.UserRepository();
        UserService userService = new learnEnglish.service.impl.UserService();

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
                    userService.authentication(userRepository);
                    break;
                case 2:
                    userService.registration(userRepository);
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