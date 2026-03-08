package oop.principles.inheritance;

public class InheritancePrinciple {

    public void inheritance(){

        HotDrinksCaffe caffe = new HotDrinksCaffe("Tea","1$");
        Americano americano = new Americano("Americano","3$");

        // Here we take attributes and use methods from parent class

        System.out.println( " If you don't make any order than you will get " + caffe.getDrinkName() + " at price " + caffe.getDrinkPrice());


        // Here child class use methods of parent class

        System.out.println( "Oh you wanna americano\n\n\n" +
                            "\tProcessing . . . \n\n\n" +
                            "Your order is " + americano.getDrinkName() + " at price " + americano.getDrinkPrice());


    }

}
