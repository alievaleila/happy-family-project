package az.edu.turing.happyfamilyv1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Human {

    private String name;
    private String surname;
    private int birthYear;
    private int iq;
    private Family family;
    Map<String, String> schedule;

    public Human() {
        schedule = new HashMap<>();
    }

    public Human(String name, String surname, int birthYear) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        schedule = new HashMap<>();
    }

    public Human(String name, String surname, int birthYear, int iq, Family family) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.iq = iq;
        this.family = family;
        schedule = new HashMap<>();

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

    public Map<String, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, String> schedule) {
        this.schedule = schedule;
    }

    public void addSchedule(String day, String activity) {
        schedule.put(day, activity);
    }

    public void greetPet() {
        if (family != null && family.getPets() != null) {
            for (Object obj : family.getPets()) {
                if (obj instanceof Pet) {
                    Pet pet = (Pet) obj;
                    System.out.println("Hello, " + pet.getNickname());
                }
            }
        }
    }

    public void describePet() {
        if (family != null && !family.getPets().isEmpty()) {
            for (Object obj : family.getPets()) {
                if (obj instanceof Pet) {
                    Pet pet = (Pet) obj; // Type casting to Pet
                    String slyness = pet.getTrickLevel() > 50 ? "very sly" : "almost not sly";
                    System.out.println("I have a " + pet.getSpecies().toString().toLowerCase() +
                            ", he is " + pet.getAge() + " years old, he is " + slyness);
                }
            }
        }
    }

    @Deprecated
    @SuppressWarnings("removal")
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
                ", birthYear=" + birthYear +
                ", iq=" + iq +
                ", family=" + family +
                '}';
    }
}
