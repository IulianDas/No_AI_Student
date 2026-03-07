package oop.principles.inheritance;

public class Americano extends HotDrinksCaffe{

    public String name = "Americano El Grande";
    public String price = "4$";

    @Override
    public String orderDrink() {
        return this.name;
    }

    @Override
    public String orderPrice() {
        return this.price;
    }
}
