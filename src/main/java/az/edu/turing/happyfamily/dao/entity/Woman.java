package az.edu.turing.happyfamily.dao.entity;

import java.time.LocalDate;

public class Woman extends Human {

    public Woman() {


    }

    public Woman(String name, String surname, int birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    public Woman(String childrenName, String surname, int currentYear) {
        super(childrenName, surname, currentYear);
    }

    public Woman(String lisa, String smith, LocalDate of, int iq) {
        super(lisa, smith, of, iq);
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
