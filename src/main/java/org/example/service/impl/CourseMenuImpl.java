package org.example.service.impl;

import org.example.entity.Course;
import org.example.service.CourseMenu;
import org.example.service.CourseService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseMenuImpl implements CourseMenu {


    private final CourseService courseService;

    public CourseMenuImpl(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public void getCourseMenu(int userId) throws SQLException {

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
                    courseService.getAllCourses();
                    break;
                case 2:
                    List<Integer> ids = courseService.getCourseListByUsersId(userId);
                    List<Course> courses = new ArrayList<>();
                    for (Integer id:ids){
                        courses.add(courseService.getCourseById(id));
                    }
                    if (courses.isEmpty()){
                        System.out.println("\n You don't start any courses!\n");
                        break;
                    }else {
                        System.out.println("\n You can continue follow course(s):\n");
                        courseService.getStartedCourses(courses);
                        courseService.startLesson(userId);
                        break;
                    }
                case 3:
                    courseService.getAllCourses();
                    courseService.startLesson(userId);
                    break;
                case 4:
                    courseService.getUserProgress(userId);
                    break;
                case 0:
                    tokenMenu = false;
                    break;
            }

    }
}



}
