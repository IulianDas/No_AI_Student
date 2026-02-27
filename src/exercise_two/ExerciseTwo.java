package exercise_two;
import java.util.Scanner;

public class ExerciseTwo{

    public void exerciseTwoMenu(){
        boolean tokenTask2 = true;
        while (tokenTask2) {
            System.out.println("\n------------ Exercise Two -------------\n " +
                    "\tWhat do you want to check from Exercise Two:\n \t\t " +
                    "1) Exercise to reverse the row.\n  \t\t " +
                    "2) Exercise with second biggest number from matrix.\n \t\t " +
                    "3) Fibonacci until the number.\n \t\t " +
                    "4) Fibonacci recursive.\n \t\t" +
                    " 0) Exit.\n" +
                    "---------------------------------------\n");
            Scanner menu = new Scanner(System.in);
            int choiseExerciseTwo = menu.nextInt();

            switch (choiseExerciseTwo) {
                case 1:
                    myFirst();
                    break;
                case 2:
                    mySecond();
                    break;
                case 3:
                    myThird();
                    break;
                case 4:
                    myFourth();
                    break;
                case 0:
                    tokenTask2 = false;
                    break;
            }
        }
    }
    public void myFirst(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the row:");
        String reversePhrase = keyboard.nextLine();

        for (int i = reversePhrase.length()-1; i >= 0; i-- ){
            System.out.print(reversePhrase.charAt(i));
        }
        System.out.print("\nDone\n");
    }

    public void mySecond(){
        int cache = 0;
        int max = 0;
        int[][] myMatrix = { {1,5,6}
                            ,{7,3,6}
                            ,{11,10,2} };

        for (int i = 0; i < myMatrix.length; i++){
            System.out.println("\n");
            for(int j = 0; j < myMatrix[i].length; j++) {
            System.out.print(myMatrix[i][j] + " ");
            }
        }
        System.out.println("\n");

        for (int i = 0; i < myMatrix.length; i++){
            for(int j = 0; j < myMatrix[i].length; j++){
                if( myMatrix[i][j] > max){
                   cache = max;
                   max = myMatrix[i][j];
               } else if (myMatrix[i][j] > cache) {
                    cache = myMatrix[i][j];
                }
            }
        }
        System.out.print("The second biggest number is: " + cache);
        System.out.print("\nDone\n");
    }

    public void myThird(){
        int number1 = 0;
        int number2 = 1;
        int total = 0;

        System.out.print("Until witch number to show Fibonacci numbers: ");
        Scanner keyboard = new Scanner(System.in);
        int fibonacciNum = keyboard.nextInt();

        System.out.print("Fibonacci series numbers are: ");

        if (fibonacciNum == 0){
            System.out.print(" 0 ");
            System.out.print("\nDone\n");
        }
        else {
            System.out.print(number1 + "  " + number2 + "  ");
            while (fibonacciNum > total){
                total = number1 + number2;
                if (fibonacciNum >= total){
                    System.out.print(total + "  ");
                }
                number1 = number2;
                number2 = total;
            }
            System.out.print("\nDone\n");
        }
    }

    public void myFourth(){

        int number1 = 0;
        int number2 = 1;
        int total = 0;
        int counter = 2;

        System.out.print("Until witch number to show Fibonacci numbers: ");
        Scanner keyboard = new Scanner(System.in);
        int fibonacciNum = keyboard.nextInt();

        while (fibonacciNum > total){
            total = number1 + number2;
            if (fibonacciNum >= total){
            counter= counter+1;
            }
            number1 = number2;
            number2 = total;
        }

        System.out.print("Fibonacci series of numbers are: \n");

        for (int i = 0; i < counter; i++) {
            System.out.print(recursion(i) + " ");
        }
        System.out.print("\nDone\n");
    }

    public static int recursion(int count) {
        if (count == 0) {
            return 0;
        }
        if (count == 1 || count == 2) {
            return 1;
        }

        return recursion(count - 1) + recursion(count - 2);
    }


}
