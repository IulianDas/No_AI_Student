package exercise_three;

import java.util.Arrays;
import java.util.Scanner;

public class ExerciseThree {

    public void exerciseThreeMenu(){
        boolean tokenExerciseThree = true;
        while (tokenExerciseThree) {
            System.out.println("\n----------- Exercise Three ------------\n " +
                    "\tWhat do you want to check from Exercise Three:\n \t\t " +
                    "1) Check if given string is a palindrome.\n  \t\t " +
                    "2) Verify if number from Array is a prime number.\n \t\t " +
                    "3) How much each number is repeating in Array.\n \t\t " +
                    "0) Exit.\n" +
                    "---------------------------------------\n");
            Scanner menu = new Scanner(System.in);
            int choiseExerciseThree = menu.nextInt();

            switch (choiseExerciseThree) {
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
                    tokenExerciseThree = false;
                    break;
            }
        }
    }

    public void myFirst (){

        int i, j;
        int counter = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nEnter the row to verify if it is a palindrome:");

        char [] stringArray = keyboard.nextLine().toLowerCase().toCharArray();
        j = stringArray.length - 1;

        if ((stringArray.length % 2) == 0){
            for (i = 0; i <= (stringArray.length / 2) - 1 ; i++){
                if (stringArray[i] != stringArray[j]){
                    counter+=1;
                }
                j-=1;
            }
        }
        else {
            for (i = 0; i < (stringArray.length / 2) - 1 ; i++){
                if (stringArray[i] != stringArray[j]){
                    counter+=1;
                }
                j-=1;
            }
        }
        if (counter == 0) {
            System.out.println("String is a palindrome");
        }
        else {
            System.out.println("String is not a palindrome");
        }

        System.out.print("\nDone\n");
    }

    public void mySecond (){

        int [] arrayOfNumbers = {1, 93, 4, 16, 28, 9, 37 ,32, 15, 13, 21, 205, 30, 41, 2, 58, 83, 75, 67};
        int i, j;

        //Show array in console
        System.out.print("Array of numbers are: "  + arrayOfNumbers[0]);

        for (i = 1; i < arrayOfNumbers.length; i++){
            System.out.print(", " + arrayOfNumbers[i]);
        }

        //Main logic
        System.out.print("\n\nPrime numbers from array are: ");

        for (i = 0; i < arrayOfNumbers.length; i++){
            j = 2;
            if (arrayOfNumbers[i] != 0 || arrayOfNumbers[i] != 1) {
                while (true) {
                    if (arrayOfNumbers[i] % j == 0 && arrayOfNumbers[i] != j) {
                        break;
                    } else if (arrayOfNumbers[i] == j) {
                        System.out.print(arrayOfNumbers[i] + "  ");
                        break;
                    }
                    j += 1;
                }
            }
        }

        System.out.print("\nDone\n");

    }



    public void myThird (){

        int i, j;
        int counter = 0;
        int [] arrayOfNumbers = {1, 2, 0, 4, 13, 2, 9, 3 ,2, 0, 1, 13, 1, 2, 18, 1, 2, 5, 5, 7, 17};
        int [] arrayBuffer = new int[arrayOfNumbers.length];

        // Show array in console
        System.out.print("Array of numbers are: "  + arrayOfNumbers[0]);
        for (i = 1; i <= arrayOfNumbers.length -1; i++){
            System.out.print(", " + arrayOfNumbers[i]);
        }

        // Checking all 0 before it will affect the logic
        for (i = 0; i <= arrayOfNumbers.length - 1; i++) {
            if (arrayOfNumbers[i] == 0) {
                counter+=1;
            }
        }
        System.out.println("\nNumber 0 is repeating " + counter + " times");

        //Optional sort for the output beauty
        Arrays.sort(arrayOfNumbers);

        //Main logic
        for (i = 0; i <= arrayOfNumbers.length -1; i++) {

            counter = 0;

            //Checking if this number already was counted
            for (j = 0; j <= i; j++) {
                if (arrayOfNumbers[i] == arrayBuffer [j]) {
                    counter+=1;
                }
            }
            if (counter == 0) {
                for (j = 0; j <= arrayOfNumbers.length -1; j++) {
                    if (arrayOfNumbers[i] == arrayOfNumbers [j]) {
                        counter+=1;
                    }
                }
                System.out.println("Number " +arrayOfNumbers[i] +  " is repeating " + counter + " times");
                arrayBuffer[i] = arrayOfNumbers[i];
            }


        }
        System.out.print("\nDone\n");
    }

}
