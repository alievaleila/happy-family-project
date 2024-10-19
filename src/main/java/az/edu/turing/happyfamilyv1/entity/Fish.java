package az.edu.turing.happyfamilyv1.entity;

import az.edu.turing.happyfamilyv1.model.Species;

import java.util.Set;

public class Fish extends Pet {

    public Fish(Species species, String nickname) {
        super(species, nickname);
    }

    public Fish(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.FISH);
    }

    @Override
    public void respond() {
        System.out.println("Fish " + getNickname() + " says: Blub blub!");
    }
}

