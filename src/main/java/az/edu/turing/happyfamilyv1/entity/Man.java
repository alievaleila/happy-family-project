package az.edu.turing.happyfamilyv1.entity;

public class Man extends Human {

    public Man(String name, String surname, int birthYear, double fatherIq) {
        super(name, surname, (long) birthYear, (int) fatherIq);
    }

    public Man(String fatherName, String fatherLastName, int fatherBirthYear, int fatherBirthMonth, int fatherBirthDay, int fatherIq) {
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
