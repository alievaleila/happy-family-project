package az.edu.turing.happyfamilyv1;

public class Dog extends Pet implements Foul {

    public Dog(String nickname) {
        super("DOG", nickname);
    }

    public Dog(String nickname, int age, int trickLevel, String[] habits) {
        super("DOG", nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Dog " + getNickname() + " says: Woof woof!");
    }

    @Override
    public void foul() {
        System.out.println("Dog " + getNickname() + " has fouled.");
    }
}
