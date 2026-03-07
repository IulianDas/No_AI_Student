import oop.OOP;
import syntax.SyntaxMenu;
import syntax.exercise_four.ExerciseFour;
import syntax.exercise_one.ExerciseOne;
import syntax.exercise_three.ExerciseThree;
import syntax.exercise_two.ExerciseTwo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SyntaxMenu syntaxMenu = new SyntaxMenu();
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
        }

    }
}