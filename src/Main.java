import exercise_four.ExerciseFour;
import exercise_one.ExerciseOne;
import exercise_three.ExerciseThree;
import exercise_two.ExerciseTwo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ExerciseOne exercise1 = new ExerciseOne();
        ExerciseTwo exercise2 = new ExerciseTwo();
        ExerciseThree exercise3 = new ExerciseThree();
        ExerciseFour exercise4= new ExerciseFour();
        boolean tokenMenu = true;

        while(tokenMenu) {
            System.out.print("\n------------ Main Menu -------------\n" +
                    "\tChose exercise to test:\n" +
                    "\t\t1) Exercise One\n" +
                    "\t\t2) Exercise Two\n" +
                    "\t\t3) Exercise Three\n" +
                    "\t\t4) Exercise Four\n" +
                    "\t\t0) Exit" +
                    "\n------------------------------------\n");

            Scanner menu = new Scanner(System.in);
            int menuChoise = menu.nextInt();

            switch (menuChoise) {
                case 1:
                    exercise1.exerciseOneMenu();
                    break;
                case 2:
                    exercise2.exerciseTwoMenu();
                    break;
                case 3:
                    exercise3.exerciseThreeMenu();
                    break;
                case 4:
                    exercise4.exerciseFourMenu();
                    break;
                case 0:
                    tokenMenu = false;
                    break;
            }
        }
    }
}