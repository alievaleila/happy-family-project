package az.edu.turing.happyfamily.dao.entity;

import az.edu.turing.happyfamily.model.Species;

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

