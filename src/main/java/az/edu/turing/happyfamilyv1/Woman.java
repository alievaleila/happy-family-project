package az.edu.turing.happyfamilyv1;

public class Woman extends Human{

    public Woman(String name, String surname, int birthYear) {
        super(name, surname, birthYear);
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
