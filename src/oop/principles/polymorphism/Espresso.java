package oop.principles.polymorphism;

import oop.principles.inheritance.HotDrinksCaffe;

public class Espresso extends HotDrinksCaffe {

    public Espresso(String drinkName, String drinkPrice){
        super(drinkName,drinkPrice);
    }

    public Espresso() {
        super();
    }

    public void setEspresso(){
        super.setDrinkName("Espresso");
    }
    public void setEspresso(String drinkName){
        super.setDrinkName(drinkName);
    }
}
