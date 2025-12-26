package az.edu.turing.happyfamily.dao.entity;

import az.edu.turing.happyfamily.model.Species;

import java.util.Set;

public class RoboCat extends Pet implements Foulable {

    public RoboCat(String nickname) {
        super(nickname);
        setSpecies(Species.ROBO_CAT);
    }

    public RoboCat(String nickname, Integer age, Integer trickLevel, Set<String> habits) {
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
