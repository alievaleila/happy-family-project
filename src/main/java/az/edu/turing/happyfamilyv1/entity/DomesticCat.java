package az.edu.turing.happyfamilyv1.entity;

import az.edu.turing.happyfamilyv1.model.Species;

import java.util.Set;

public class DomesticCat extends Pet implements Foulable {

    public DomesticCat(Species species, String nickname) {
        super(species, nickname);
    }

    public DomesticCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.DOMESTIC_CAT);

    }
    public DomesticCat(){

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

