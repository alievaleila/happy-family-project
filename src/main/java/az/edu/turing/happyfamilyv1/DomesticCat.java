package az.edu.turing.happyfamilyv1;

public class DomesticCat extends Pet implements Foul {

    public DomesticCat(String nickname) {
        super("CAT", nickname);
    }

    public DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
        super("CAT", nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("DomesticCat " + getNickname() + " says: Meow meow!");
    }

    @Override
    public void foul() {
        System.out.println("DomesticCat " + getNickname() + " has fouled.");
    }
}

