package learnEnglish.service.impl;

import learnEnglish.entity.User;

import java.util.Scanner;

public class AdminMenu implements learnEnglish.service.AdminMenu {
    @Override
    public void getAdminMenu(User user) {
        boolean tokenMenu = true;
        while (tokenMenu){
            System.out.print("\n--------- English Lesson -----------\n"
                    +"\t\n"
                    +"\t\t1) Create Course\n"
                    +"\t\t2) Create Lesson\n"
                    +"\t\t3) Create Quiz\n"
                    +"\t\t4) Options\n"
                    +"\t\t0) Logout\n"
                    +"\n------------------------------------\n");

            Scanner menu = new Scanner(System.in);
            int menuChoise = menu.nextInt();
            switch (menuChoise) {
                case 1:
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    tokenMenu = false;
                    break;
            }

        }
    }
}
