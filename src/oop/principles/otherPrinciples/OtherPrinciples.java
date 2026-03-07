package oop.principles.otherPrinciples;

import java.util.Scanner;

public class OtherPrinciples {

    public void OtherPrMenu() {
        boolean tokenOPM = true;

        while (tokenOPM) {

            //TODO When we will continue to study, I will fulfill this repo

            System.out.print("\n------------ Other Principles -------------\n" +
                    "\tChose exercise to test:\n" +
                    "\t\t1) DRY (Don't Repeat Yourself)\n" +
                    "\t\t2) KISS (Keep It Simple Stupid)\n" +
                    "\t\t0) Exit" +
                    "\n------------------------------\n");

            Scanner menu = new Scanner(System.in);
            int menuChoise = menu.nextInt();

            switch (menuChoise) {
                case 1:

                    break;
                case 2:

                    break;
                case 0:
                    tokenOPM = false;
                    break;
            }
        }
    }
}
