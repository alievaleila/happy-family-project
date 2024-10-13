package az.edu.turing.happyfamilyv1;

public class Man extends Human {

    public Man(String name, String surname, int birthYear) {
        super(name, surname, birthYear);
    }

    @Override
    public void greetPet() {
        if (getFamily() != null && !getFamily().getPets().isEmpty()) {
            for (Object obj : getFamily().getPets()) {
                if (obj instanceof Pet) {
                    Pet pet = (Pet) obj; // Type casting to Pet
                    System.out.println("Hello, " + pet.getNickname() + "! Time to go for a walk.");
                }
            }
        }
    }

    public void repairCar() {
        System.out.println(getName() + " is repairing the car.");
    }
}
