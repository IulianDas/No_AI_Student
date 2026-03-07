package oop.principles.inheritance;

public class InheritancePrinciple {

    HotDrinksCaffe caffe = new HotDrinksCaffe();
    Americano americano = new Americano();

    public void inheritance(){

        // Here we take attributes and use methods from parent class

        System.out.println( " If you don't make any order than you will get " + caffe.orderDrink() + " at price " + caffe.orderPrice());


        // Here child class use methods of parent class

        System.out.println( "Oh you wanna americano\n\n\n" +
                            "\tProcessing . . . \n\n\n" +
                            "Your order is " + americano.orderDrink() + " at price " + americano.orderPrice());


    }

}
