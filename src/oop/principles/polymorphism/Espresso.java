package oop.principles.polymorphism;

import oop.principles.inheritance.HotDrinksCaffe;

public class Espresso extends HotDrinksCaffe {

    public String name = "Espresso Italiano";
    public String price = "3$";

    @Override
    public String orderDrink() {
        return this.name;
    }

    @Override
    public String orderPrice() {
        return this.price;
    }
}
