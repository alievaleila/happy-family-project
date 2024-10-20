package az.edu.turing.happyfamilyv1.entity;

import az.edu.turing.happyfamilyv1.model.DayOfWeek;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Human {

    private String name;
    private String surname;
    private long birthYear, birthMonth, birthDay;
    private int iq;
    private Family family;
    private Pet pet;
    Map<String, String> schedule;

    public Human() {
        schedule = new HashMap<>();
    }

    public Human(String name, String surname, long birthYear, int iq) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.iq = iq;
//        this.schedule = (schedule != null) ? schedule : new HashMap<>();
    }

    public Human(String name, String surname, long birthYear, long birthMonth, long birthDay, int iq, Map<DayOfWeek, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.iq = iq;
        this.schedule = new HashMap<>();

    }

    public Human(String name, String surname, long birthYear, long birthMonth, long birthDay, double iq) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.iq = (int) iq;
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

    public long getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(long birthYear) {
        this.birthYear = birthYear;
    }

    public long getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(long birthMonth) {
        this.birthMonth = birthMonth;
    }

    public long getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(long birthDay) {
        this.birthDay = birthDay;
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

    public String prettyFormat() {
        return String.format("{name='%s', surname='%s', birthYear='%s', birthMonth='%s', birthDay='%s', iq=%d, schedule=%s}",
                name, surname, birthYear, birthMonth, birthDay, iq, schedule != null ? schedule.toString() : "null");
    }


    public void greetPet() {
        if (family != null && family.getPets() != null) {
            for (Pet pet : family.getPets()) {
                System.out.println("Hello," + pet.getNickname());
            }
        }
    }

    public String describePet() {
        StringBuilder result = new StringBuilder();
        for (Pet pet : family.getPets()) {
            String slyLevel = pet.getTrickLevel() > 50 ? "very sly" : "almost not sly";
            result.append(String.format("I have a %s, it is %d years old, and it is %s.\n",
                    pet.getSpecies(), pet.getAge(), slyLevel));
        }
        return result.toString();
    }

    public String describeAge() {
        LocalDate birthLocalDate = Instant.ofEpochMilli(birthYear).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now();
        Period age = Period.between(birthLocalDate, today);

        return "Age: " + age.getYears() + " years, " + age.getMonths() + " months, and " + age.getDays() + " days.";
    }

    @SuppressWarnings({"deprecation", "removal"})
    @Override
    protected void finalize() {
        System.out.println("Human object is being removed: " + this.getName() + " " + this.getSurname());
    }


    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formattedBirthDate = sdf.format(new Date(birthYear));
        return String.format("{name='%s', surname='%s', birthYear='%s', birthMonth='%s', birthDay='%s', iq=%d, schedule=%s}",
                name, surname, birthYear, birthMonth, birthDay, iq, schedule != null ? schedule.toString() : "null");
    }
}
