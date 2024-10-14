package az.edu.turing.happyfamilyv1;

public class Dog extends Pet implements Foulable {

    public Dog(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.DOG);
    }

    @Override
    public void respond() {
        System.out.println("Woof! I am a dog named" + getNickname());
    }

    @Override
    public void foul() {
        System.out.println("Oops! I made a mess");
    }
}
