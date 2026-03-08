package syntax.exercise_one;

import java.util.Scanner;

public class ExerciseOne {

    public void exerciseOneMenu(){

        boolean tokenExerciseOne = true;
        while (tokenExerciseOne) {
            System.out.println("\n------------ Exercise One -------------\n " +
                    "\tWhat do you want to check from Exercise One:\n \t\t " +
                    "1) Exercise to extract all even numbers from array.\n  \t\t " +
                    "2) Exercise to count all vowels from the string.\n \t\t " +
                    "3) Factorial number calculation.\n \t\t " +
                    "0) Exit.\n" +
                    "---------------------------------------\n");
            Scanner menu = new Scanner(System.in);
            int choiseExerciseOne = menu.nextInt();

            switch (choiseExerciseOne) {
                case 1:
                    myFirst();
                    break;
                case 2:
                    mySecond();
                    break;
                case 3:
                    myThird();
                    break;
                case 0:
                    tokenExerciseOne = false;
                    break;
            }
        }
    }

    public void myFirst (){

        int [] arrayOfNumbers = {1, 9, 4, 16, 28, 15, 37, 21, 205, 30, 41, 2, 58, 9, 75, 68};
        int i;
        System.out.print("Array of numbers are: "  + arrayOfNumbers[0]);
        for (i = 1; i < arrayOfNumbers.length - 1; i++){
            System.out.print(", " + arrayOfNumbers[i]);
        }
        System.out.print("\n\nEven numbers from array are: ");
        for (i = 0; i < arrayOfNumbers.length - 1; i++){
            if ((arrayOfNumbers[i] % 2) == 0) {
                System.out.print(arrayOfNumbers[i] + " ");
            }
        }
        System.out.print("\nDone\n");
    }


    public void mySecond (){

        int vowelCounter = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nEnter the row:");

        char [] stringArray = keyboard.nextLine().toLowerCase().toCharArray();

        for (char vowel: stringArray){
            if (vowel == 'a' || vowel == 'e' || vowel == 'i' || vowel == 'o' || vowel == 'u'){
                vowelCounter+=1;
            }
        }
        System.out.print("\nTotal vowels in string: " + vowelCounter);
        System.out.print("\nDone\n");
    }

    public void myThird (){

        long result = 1;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nEnter the number to calculate his factorial value:");
        int number = keyboard.nextInt();

        for (int i = 1; i <= number; i++){
            result *=i;
        }
        System.out.println("Value of factorial: " + result);
        System.out.print("\nDone\n");
    }

}
