package az.edu.turing.happyfamilyv1;

public class RoboCat extends Pet implements Foul {

    public RoboCat(String nickname) {
        super("ROBOCAT", nickname);
    }

    public RoboCat(String nickname, int age, int trickLevel, String[] habits) {
        super("ROBOCAT", nickname, age, trickLevel, habits);
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
