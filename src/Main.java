import exercise_two.ExerciseTwo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ExerciseTwo exercise2 = new ExerciseTwo();
        boolean token = true;

        while (token) {
            System.out.println("________________________________________________\n " +
                            "\tWhat do you want to check from ExerciseTwo:\n \t\t " +
                            "1) Exercise to reverse the row.\n  \t\t " +
                            "2) Exercise with second biggest number from matrix.\n \t\t " +
                            "3) Fibonacci until the number.\n \t\t " +
                            "4) Fibonacci recursive.\n \t\t" +
                            " 5) Exit.\n" +
                            "________________________________________________" );
            Scanner menu = new Scanner(System.in);
            int choise = menu.nextInt();

            switch (choise){
                case 1:
                    exercise2.myFirst();
                    break;
                case 2:
                    exercise2.mySecond();
                    break;
                case 3:
                    exercise2.myThird();
                    break;
                case 4:
                    exercise2.myFourth();
                    break;
                case 5:
                    token = false;
                    break;
            }
        }

    }
}