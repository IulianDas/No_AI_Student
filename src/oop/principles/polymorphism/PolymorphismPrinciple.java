package oop.principles.polymorphism;

import oop.principles.inheritance.Americano;
import oop.principles.inheritance.HotDrinksCaffe;

public class PolymorphismPrinciple {

    HotDrinksCaffe caffe = new HotDrinksCaffe();
    Americano americano = new Americano();
    Espresso espresso = new Espresso();
    StatusCheck statusCheck = new StatusCheck();

    // Implementation of Caffe menu is in HotDrinkCaffe class
    // We have 2 realization of this in 2 different classes

    public void polymorphism (){

        // Here we take attributes and use methods from parent class

        System.out.println( " Basic order is: " + caffe.orderDrink() + " at price " + caffe.orderPrice() + "\n");


        // Here child classes use methods of parent class and shows inheritance and polymorphism

        System.out.println(" Caffe menu contain: " + americano.orderDrink() + " " + americano.orderPrice() +
                           "\n\t\t\t\t\t " + espresso.orderDrink() + " " + espresso.orderPrice() +
                           "\n------------------------------------\n");


        //Also other classes that use parent class could see child classes.

        statusCheck.statusCheck(caffe);
        statusCheck.statusCheck(americano);
        statusCheck.statusCheck(espresso);

    }

}
