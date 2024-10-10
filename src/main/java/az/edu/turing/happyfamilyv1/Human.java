package az.edu.turing.happyfamilyv1;

import java.util.Arrays;
import java.util.Objects;

public class Human {

    private String name;
    private String surname;
    private int birthYear;
    private int iq;
    private Pet pet;
    private Human mother;
    private Human father;
    private String[][] schedule;

    public Human() {
    }

    public Human(String name, String surname, int birthYear) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    public Human(String name, String surname, int birthYear, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, int birthYear, int iq, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.iq = iq;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public void greetPet() {
        System.out.println("Hello, " + this.pet.getNickname());
    }

    public void describePet() {
        String slyness = this.pet.getTrickLevel() > 50 ? "very sly" : "almost not sly";
        System.out.println("I have a " + this.pet.getSpecies() + ", he is " + this.pet.getAge() + " years old, he is " + slyness);
    }

    @Override
    public String toString() {
        if (this.pet != null) {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", year=" + birthYear +
                    ", iq=" + iq +
                    ", mother=" + mother +
                    ", father=" + father +
                    ", pet=" + pet.getSpecies() + '{' +
                    "nickname='" + pet.getNickname() + '\'' +
                    ", age=" + pet.getAge() +
                    ", trickLevel=" + pet.getTrickLevel() +
                    ", habits=" + Arrays.toString(pet.getHabits()) +
                    '}';
        }
        else {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", year=" + birthYear +
                    ", iq=" + iq +
                    ", mother=" + mother +
                    ", father=" + father + '}';
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthYear == human.birthYear && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(pet, human.pet) && Objects.equals(mother, human.mother) && Objects.equals(father, human.father) && Arrays.equals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, birthYear, iq, pet, mother, father);
        result = 31 * result + Arrays.hashCode(schedule);
        return result;
    }
}
