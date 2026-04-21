package org.example.service.impl;

import org.example.service.AdminMenu;
import org.example.service.AdminService;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminMenuImpl implements AdminMenu {


    private final AdminService adminService;

    public AdminMenuImpl(AdminService adminService) {

        this.adminService = adminService;
    }

    @Override
    public void getAdminMenu(int userId) throws SQLException {
        boolean tokenMenu = true;
        while (tokenMenu){
            System.out.print("\n---------- Admin Menu ------------\n"
                    +"\t\n"
                    +"\t\t1) Show all Courses\n"
                    +"\t\t2) Update Course\n"
                    +"\t\t3) Create Course\n"
                    +"\t\t4) Delete Course\n"
                    +"\t\t0) Logout\n"
                    +"\n------------------------------------\n");

            Scanner menu = new Scanner(System.in);
            int menuChoise = menu.nextInt();
            switch (menuChoise) {
                case 1:
                    adminService.getAllCourses();
                    break;
                case 2:
                    adminService.updateSelectedCourse();
                    break;
                case 3:
                    adminService.createCourse();
                    break;
                case 4:
                    adminService.getAllCourses();
                    System.out.println(" Chose course to delete: \n");
                    adminService.deleteCourseById(menu.nextInt());
                    break;
                case 0:
                    tokenMenu = false;
                    break;
            }

        }
    }
}
