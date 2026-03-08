package oop.principles.polymorphism;

import oop.principles.inheritance.Americano;
import oop.principles.inheritance.HotDrinksCaffe;

public class PolymorphismPrinciple {



    // Implementation of Caffe menu is in HotDrinkCaffe class
    // We have 2 realization of this in 2 different classes

    public void polymorphism (){

        HotDrinksCaffe caffe = new HotDrinksCaffe("Tea","1$");
        HotDrinksCaffe americano = new Americano("Americano","3$");
        HotDrinksCaffe espresso = new Espresso("Espresso","2.5$");
        Espresso lungo = new Espresso();
        lungo.setEspresso("Lungo");
        lungo.setDrinkPrice("4$");
        StatusCheck statusCheck = new StatusCheck();

        // Here we take attributes and use methods from parent class

        System.out.println( " Basic order is: " + caffe.getDrinkName() + " at price " + caffe.getDrinkPrice() + "\n");


        // Here child classes use methods of parent class and shows inheritance and polymorphism

        System.out.println(" Caffe menu contain: " + americano.getDrinkName() + " " + americano.getDrinkPrice() +
                           "\n\t\t\t\t\t " + espresso.getDrinkName() + " " + espresso.getDrinkPrice() +
                           "\n\t\t\t\t\t " + lungo.getDrinkName() + " " + lungo.getDrinkPrice() +
                           "\n------------------------------------\n");


        //Also other classes that use parent class could see child classes.

        statusCheck.statusCheck(caffe);
        statusCheck.statusCheck(americano);
        statusCheck.statusCheck(espresso);

    }

}
