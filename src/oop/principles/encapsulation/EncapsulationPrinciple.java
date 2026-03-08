package oop.principles.encapsulation;

import java.util.Scanner;

public class EncapsulationPrinciple {


    public void encapsulationPrinciple(){
        EncapsulationExample encapsulationExample = new EncapsulationExample();

        //Encapsulation stands to control access to data
        //To access data and modify, is used setters and getters
        System.out.println(encapsulationExample.getSenseOfEncapsulation());

        System.out.println("\n To Verify if it is work" +
                           "\n Introducenew String value: ");
        Scanner scanner = new Scanner(System.in);

        encapsulationExample.setEncapsulated(scanner.nextLine());
        System.out.println("\nValue is: " + encapsulationExample.getEncapsulated());


    }
}
