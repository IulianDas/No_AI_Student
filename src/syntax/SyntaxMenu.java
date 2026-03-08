package syntax;

import syntax.exercise_four.ExerciseFour;
import syntax.exercise_one.ExerciseOne;
import syntax.exercise_three.ExerciseThree;
import syntax.exercise_two.ExerciseTwo;

import java.util.Scanner;

public class SyntaxMenu {
    ExerciseOne exercise1 = new ExerciseOne();
    ExerciseTwo exercise2 = new ExerciseTwo();
    ExerciseThree exercise3 = new ExerciseThree();
    ExerciseFour exercise4= new ExerciseFour();
    boolean tokenSyntax = true;
    public void syntaxMenu(){

        while(tokenSyntax) {
            System.out.print("\n------------ Syntax Menu -------------\n" +
                    "\tChose exercise to test:\n" +
                    "\t\t1) Exercise One\n" +
                    "\t\t2) Exercise Two\n" +
                    "\t\t3) Exercise Three\n" +
                    "\t\t4) Exercise Four\n" +
                    "\t\t0) Exit" +
                    "\n--------------------------------------\n");

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
                    tokenSyntax = false;
                    break;
            }
        }
    }




}
