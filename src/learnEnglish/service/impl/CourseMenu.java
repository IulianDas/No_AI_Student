package learnEnglish.service.impl;

import learnEnglish.entity.Course;
import learnEnglish.entity.Lesson;
import learnEnglish.entity.User;
import learnEnglish.repository.CourseRepository;

import java.util.Scanner;

public class CourseMenu implements learnEnglish.service.CourseMenu {
    @Override
    public void getCourseMenu(User user) {

        CourseRepository courses = new learnEnglish.repository.impl.CourseRepository();
        Course curs;
        Lesson lesson;

        boolean tokenMenu = true;
        while (tokenMenu){
            System.out.print("\n--------- English Lesson -----------\n"
                    +"\t\n"
                    +"\t\t1) Get All Courses\n"
                    +"\t\t2) Continue\n"
                    +"\t\t3) Start New Course\n"
                    +"\t\t4) Check Progress\n"
                    +"\t\t0) Logout\n"
                    +"\n------------------------------------\n");

            Scanner menu = new Scanner(System.in);
            int menuChoise = menu.nextInt();
            switch (menuChoise) {
                case 1:
                    curs = courses.getCourse();
                    System.out.println(curs.getId() + "" + curs.getName() + "" + curs.getLessons() );
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
