package oop.principles.encapsulation;

public class EncapsulationExample {

    private String encapsulated = "";
    private final String senseOfEncapsulation =  "Meaning of Encapsulation, is to make sure that \"sensitive\" data is hidden from users " +
                                                        "and improve stability and security.";


    //Setter to set value of private attribute.
    public void setEncapsulated(String value){
        this.encapsulated = value;
    }

    //Getter to get value of attribute.
    public String getEncapsulated() {
        return encapsulated;
    }

    public String getSenseOfEncapsulation(){
        return senseOfEncapsulation;
    }

}
