package oop.principles.polymorphism;

import oop.principles.inheritance.HotDrinksCaffe;

public class StatusCheck {

   public void statusCheck(HotDrinksCaffe caffe){
       System.out.println("\n --- Your " + caffe.getDrinkName() + " is ready!!! ---\n");
   }
}
