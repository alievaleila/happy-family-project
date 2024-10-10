package az.edu.turing.happyfamilyv1;

import java.util.Arrays;
import java.util.Objects;

public class Human {

    private String name;
    private String surname;
    private int birthYear;
    private int iq;
    private Family family;
    private String[][] schedule;

    public Human() {
    }

    public Human(String name, String surname, int birthYear) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    public Human(String name, String surname, int birthYear, int iq, Family family, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.iq = iq;
        this.family = family;
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

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public void greetPet() {
        if (family != null && family.getPet() != null) {
            System.out.println("Hello, " + family.getPet().getNickname());
        }
    }

    public void describePet() {
        if (family != null && family.getPet() != null) {
            String slyness = family.getPet().getTrickLevel() > 50 ? "very sly" : "almost not sly";
            System.out.println("I have a " + family.getPet().getSpecies() + ", he is " + family.getPet().getAge() + " years old, he is " + slyness);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Family object is being removed.");
        } finally {
            super.finalize();
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + birthYear +
                ", iq=" + iq +
                ", schedule=" + Arrays.deepToString(schedule) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthYear == human.birthYear && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(family, human.family) && Objects.deepEquals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthYear, iq, family, Arrays.deepHashCode(schedule));
    }
}
