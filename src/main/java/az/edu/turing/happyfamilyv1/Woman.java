package az.edu.turing.happyfamilyv1;

public class Woman extends Human{

    public Woman(String name, String surname, int birthYear) {
        super(name, surname, birthYear);
    }

    public Woman(String name, String surname, int birthYear, int iq, Family family, String[][] schedule) {
        super(name, surname, birthYear, iq, family, schedule);
    }

    @Override
    public void greetPet() {
        if (getFamily() != null && getFamily().getPet() != null) {
            System.out.println("Hi, " + getFamily().getPet().getNickname() + "! Want some treats?");
        }
    }

    public void makeup() {
        System.out.println(getName() + " is applying makeup.");
    }
}
