package az.edu.turing.happyfamilyv1.entity;

public class Woman extends Human {

    public Woman(String name, String surname, int birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    public Woman(String childrenName, String surname, int currentYear) {
    }

    @Override
    public void greetPet() {
        if (getFamily() != null && getFamily().getPet() != null) {
            System.out.println("Hi my sweet Pet!");
        }
    }

    public void makeup() {
        System.out.println("Doing my makeup...");
    }
}
