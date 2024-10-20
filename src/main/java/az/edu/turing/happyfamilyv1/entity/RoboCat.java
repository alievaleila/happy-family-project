package az.edu.turing.happyfamilyv1.entity;

import az.edu.turing.happyfamilyv1.model.Species;

public class RoboCat extends Pet implements Foulable {

    public RoboCat(Species species, String nickname) {
        super(species, nickname);
    }

    public RoboCat(){

    }

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
