package learnEnglish.service.impl;

import learnEnglish.entity.Course;
import learnEnglish.entity.User;
import learnEnglish.repository.CourseRepository;
import learnEnglish.repository.UserProgressRepository;
import learnEnglish.service.CourseMenu;
import learnEnglish.service.CourseService;

import java.util.List;
import java.util.Scanner;

public class CourseMenuImpl implements CourseMenu {

    private final CourseRepository courseRepository;
    private final UserProgressRepository userProgressRepository;
    private final CourseService courseService;

    public CourseMenuImpl(CourseRepository courseRepository, UserProgressRepository userProgressRepository, CourseService courseService) {
        this.courseRepository = courseRepository;
        this.userProgressRepository = userProgressRepository;
        this.courseService = courseService;
    }

    @Override
    public void getCourseMenu(final User user) {

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
                    courseService.getAllCourses(courseRepository);
                    break;
                case 2:
                    List<Integer> ids = courseService.getCourseListByUsersId(user);
                    List<Course> courses = courseService.getCoursesByListId(ids);
                    if (courses.isEmpty()){
                        System.out.println("\n You don't start any courses!\n");
                        break;
                    }else {
                        System.out.println("\n You can continue follow course(s):\n");
                        courseService.getStartedCourses(courses);
                        courseService.startLesson(user);
                        break;
                    }
                case 3:
                    courseService.getAllCourses(courseRepository);
                    courseService.startLesson(user);
                    break;
                case 4:
                    courseService.getUserProgress(user);
                    break;
                case 0:
                    tokenMenu = false;
                    break;
            }

    }
}



}
