package az.edu.turing.happyfamilyv1.entity;

import az.edu.turing.happyfamilyv1.model.Species;

import java.util.Set;

public class Dog extends Pet implements Foulable {

    public Dog(Species species, String nickname) {
        super(species, nickname);
    }

    public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
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
