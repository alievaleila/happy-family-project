package az.edu.turing.happyfamilyv1;

import java.util.Arrays;
import java.util.Objects;

public abstract class Pet {

    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public Pet() {

    }

    public Pet(String species, String nickname) {
        this.species = Species.valueOf(species);
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = Species.valueOf(species);
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Species getSpecies() {
        return species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    public void eat() {
        System.out.println("I'm eating");
    }

    public void respond() {
        System.out.println("Hello, owner. I am -" + this.nickname + ". I miss you!");
    }

//    public void foul() {
//        System.out.println("I need to cover it up");
//    }

    @Deprecated
    @SuppressWarnings("removal")
    @Override
    public void finalize() throws Throwable {
        try {
            System.out.println("Family object is being removed.");
        } finally {
            super.finalize();
        }
    }

    @Override
    public String toString() {
        return species.name() + '{' +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && trickLevel == pet.trickLevel && Objects.equals(species, pet.species) && Objects.equals(nickname, pet.nickname) && Objects.deepEquals(habits, pet.habits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age, trickLevel, Arrays.hashCode(habits));
    }

}
