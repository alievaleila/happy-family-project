package az.edu.turing.happyfamilyv1;

public class Human {

    private String name;
    private String surname;
    private int birthYear;
    private int iq;
    private Family family;

    public Human() {
    }

    public Human(String name, String surname, int birthYear) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    public Human(String name, String surname, int birthYear, int iq, Family family) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.iq = iq;
        this.family = family;

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
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthYear=" + birthYear +
                ", iq=" + iq +
                ", family=" + family +
                '}';
    }
}
