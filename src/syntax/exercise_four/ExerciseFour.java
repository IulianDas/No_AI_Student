package syntax.exercise_four;

import java.util.Arrays;
import java.util.Scanner;

public class ExerciseFour {

    public void exerciseFourMenu(){
        boolean tokenExerciseFour = true;
        while (tokenExerciseFour) {
            System.out.println("\n----------- Exercise Four -------------\n " +
                    "\tWhat do you want to check from Exercise Four:\n \t\t " +
                    "1) Bubble sort an Array.\n  \t\t " +
                    "2) Show main diagonal from matrix 3x3.\n \t\t " +
                    "3) Anagram of two strings.\n \t\t " +
                    "0) Exit.\n" +
                    "---------------------------------------\n");
            Scanner menu = new Scanner(System.in);
            int choiseExerciseFour = menu.nextInt();

            switch (choiseExerciseFour) {
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
                    tokenExerciseFour = false;
                    break;
            }
        }
    }

    public void myFirst (){

        int i, j, buffer;
        int [] arrayOfNumbers = {1, 2, 0, 4, 13, 2, 9, 3 ,2, 0, 1, 13, 1, 2, 18, 1, 2, 5, 5, 7, 17};

        // Show array in console
        System.out.print("Array of numbers are: "  + arrayOfNumbers[0]);
        for (i = 1; i <= arrayOfNumbers.length -1; i++){
            System.out.print(", " + arrayOfNumbers[i]);
        }

        // Bubble sort this

        for (i = 0; i <= arrayOfNumbers.length; i++){
            for (j = 1; j <= arrayOfNumbers.length - 1; j++){
                if (arrayOfNumbers[j-1] > arrayOfNumbers[j]){
                    buffer = arrayOfNumbers[j];
                    arrayOfNumbers[j] = arrayOfNumbers[j-1];
                    arrayOfNumbers[j-1] = buffer;
                }
            }

        }
        // Show result in console
        System.out.print("\nSorted array : "  + arrayOfNumbers[0]);
        for (i = 1; i <= arrayOfNumbers.length -1; i++){
            System.out.print(", " + arrayOfNumbers[i]);
        }

        System.out.print("\nDone\n");
    }

    public void mySecond (){

        int cache = 0;
        int max = 0;
        int[][] myMatrix = { {1,5,6}
                            ,{7,3,6}
                            ,{11,10,2} };

        // Show array in console

        for (int i = 0; i < myMatrix.length; i++){
            System.out.println("\n");
            for(int j = 0; j < myMatrix[i].length; j++) {
                System.out.print(myMatrix[i][j] + " ");
            }
        }
        System.out.println("\n");

        //Main logic of primal diagonal

        System.out.println("Main diagonal of matrix is: ");

        for (int i = 0; i < myMatrix.length; i++){
            for (int j = 0; j < myMatrix[i].length; j++) {
                if (i == j){
                    System.out.print(myMatrix[i][j] + " ");
                }
            }
        }

        //Main logic of secondary diagonal

        System.out.println("\nSecondary diagonal of matrix is: ");

        for (int i = 0; i < myMatrix.length; i++){
            for (int j = 0; j < myMatrix[i].length; j++) {
                if(i == myMatrix.length - j - 1){
                    System.out.print(myMatrix[i][j] + " ");
                }
            }
        }

        System.out.print("\nDone\n");
    }

    public void myThird (){

        int i;
        int counter = 0;
        Scanner keyboard = new Scanner(System.in);

        // Take and show first string in console
        System.out.println("\nEnter first string:");
        char [] firstString = keyboard.nextLine().replaceAll("\\s+", "").toLowerCase().toCharArray();
        Arrays.sort(firstString);

        // Take and show second string in console
        System.out.println("\nEnter second string:");
        char [] secondString = keyboard.nextLine().replaceAll("\\s+", "").toLowerCase().toCharArray();
        Arrays.sort(secondString);

        // Main logic
        if ( firstString.length != secondString.length) {
            System.out.println("\n\nThis strings have different count of letters and can't create anagram!");
        } else {
            for (i = 0; i <= firstString.length - 1; i++) {
                if (firstString[i] != secondString[i]){
                    counter+=1;
                }
            }
            if(counter == 0){
                System.out.println("\n\nThis strings can create anagram!");
            }else {
                System.out.println("\n\nThis strings cannot create anagram!");
            }
        }

        System.out.print("\nDone\n");
    }

}
