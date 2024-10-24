package az.edu.turing.happyfamilyv1.dao.entity;

import az.edu.turing.happyfamilyv1.model.Species;

import java.util.Set;

public class Fish extends Pet {

    public Fish(String nickname) {
        super(nickname);
        setSpecies(Species.FISH);
    }

    public Fish(String nickname, Integer age, Integer trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.FISH);
    }

    @Override
    public void respond() {
        System.out.println("Fish " + getNickname() + " says: Blub blub!");
    }
}

