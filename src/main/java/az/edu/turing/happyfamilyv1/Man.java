package az.edu.turing.happyfamilyv1;

public class Man extends Human {

    public Man(String name, String surname, int birthYear) {
        super(name, surname, birthYear);
    }

    @Override
    public void greetPet() {
        if (getFamily() != null && getFamily().getPet() != null) {
            System.out.println("Hello, " + getFamily().getPet().getNickname() + "! Time to go for a walk.");
        }
    }
    public void repairCar() {
        System.out.println(getName() + " is repairing the car.");
    }
}
