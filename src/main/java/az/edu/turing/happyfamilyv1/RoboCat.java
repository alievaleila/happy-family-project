package az.edu.turing.happyfamilyv1;

public class RoboCat extends Pet implements Foulable {

    public RoboCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.ROBO_CAT);
    }

    @Override
    public void respond() {
        System.out.println("RoboCat " + getNickname() + " says: Beep boop!");
    }

    @Override
    public void foul() {
        System.out.println("RoboCat " + getNickname() + " has a system error and fouled.");
    }
}
