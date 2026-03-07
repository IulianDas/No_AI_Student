package oop;

import oop.principles.abstraction.AbstractionPrinciple;
import oop.principles.encapsulation.EncapsulationPrinciple;
import oop.principles.inheritance.InheritancePrinciple;
import oop.principles.otherPrinciples.OtherPrinciples;
import oop.principles.polymorphism.PolymorphismPrinciple;

import java.util.Scanner;

public class OOP {

    AbstractionPrinciple abstraction = new AbstractionPrinciple();
    EncapsulationPrinciple encapsulation = new EncapsulationPrinciple();
    InheritancePrinciple inheritance = new InheritancePrinciple();
    PolymorphismPrinciple poly = new PolymorphismPrinciple();
    OtherPrinciples others = new OtherPrinciples();


    public void oopMenu() {
        boolean tokenOOP = true;

        while (tokenOOP) {
            System.out.print("\n------------ Main Menu -------------\n" +
                    "\tChose principle to test:\n" +
                    "\t\t1) Abstraction\n" +
                    "\t\t2) Encapsulation\n" +
                    "\t\t3) Inheritance\n" +
                    "\t\t4) Polymorphism\n" +
                    "\t\t5) Other Principles\n" +
                    "\t\t0) Exit" +
                    "\n------------------------------------\n");

            Scanner menu = new Scanner(System.in);
            int menuChoise = menu.nextInt();

            switch (menuChoise) {
                case 1:
                    abstraction.abstractionPrinciple();
                    break;
                case 2:
                    encapsulation.encapsulationPrinciple();
                    break;
                case 3:
                    inheritance.inheritance();
                    break;
                case 4:
                    poly.polymorphism();
                    break;
                case 5:

                    break;
                case 0:
                    tokenOOP = false;
                    break;
            }
        }
    }

}
