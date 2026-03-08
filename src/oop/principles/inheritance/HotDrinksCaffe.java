package oop.principles.inheritance;

public class HotDrinksCaffe {

    private String drinkName;
    private String drinkPrice;

    public HotDrinksCaffe() {
    }

    public HotDrinksCaffe(String drinkName, String drinkPrice){
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
    }

    public void setDrinkPrice(String drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public String getDrinkPrice() {
        return drinkPrice;
    }
}
