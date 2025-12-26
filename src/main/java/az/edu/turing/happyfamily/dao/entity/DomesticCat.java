package az.edu.turing.happyfamily.dao.entity;

import az.edu.turing.happyfamily.model.Species;

import java.util.Set;

public class DomesticCat extends Pet implements Foulable {

    public DomesticCat() {

    }

    public DomesticCat(String nickname) {
        super(nickname);
        setSpecies(Species.CAT);
    }

    public DomesticCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.CAT);
    }

    public DomesticCat(String whiskers, int age, int trickLevel, String[] catHabits) {
        super(whiskers, age, trickLevel, catHabits);
    }

    @Override
    public void respond() {
        System.out.println("DomesticCat " + getNickname() + " says: Meow meow!");
    }

    @Override
    public void foul() {
        System.out.println("I scratched the sofa!");
    }
}

