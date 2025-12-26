package az.edu.turing.happyfamily.dao.entity;

import az.edu.turing.happyfamily.model.DayOfWeek;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Human {

    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private Family family;
    private Pet pet;
    Map<String, String> schedule;

    public Human() {
        schedule = new HashMap<>();
    }

    public Human(String name, String surname, long birthDate, int iq) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
    }

    public Human(String name, String surname, long birthDate, int iq, Map<DayOfWeek, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.schedule = new HashMap<>();

    }

    public Human(String name, String surname, LocalDate birthDay, double iq) {
        this.name = name;
        this.surname = surname;
        this.birthDate = convertLocalDateToMillis(birthDay);
        this.iq = (int) iq;
    }

    public Human(String lisa, String smith, int i) {
        this.name = lisa;
        this.surname = smith;
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

    public long getYear() {
        return birthDate;
    }

    public void setYear(long birthdate) {
        this.birthDate = birthdate;
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
        return String.format("{name='%s', surname='%s', birthDate='%s', IQ=%d, schedule='%s',family=%s",
                name, surname, birthDate, iq, schedule != null ? schedule.toString() : "null");
    }

    public LocalDate convertMillisLocalDate(long millisDate) {
        return new Date(millisDate).
                toInstant().
                atZone(ZoneId.systemDefault()).
                toLocalDate();
    }

    public long convertLocalDateToMillis(LocalDate localDate) {
        return localDate.
                atStartOfDay(ZoneId.systemDefault()).
                toInstant().
                toEpochMilli();
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
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDateInLocal = convertMillisLocalDate(birthDate);
        long year = ChronoUnit.YEARS.between(birthDateInLocal, currentDate);
        long month = ChronoUnit.MONTHS.between(birthDateInLocal.plusYears(year), currentDate);
        long day = ChronoUnit.DAYS.between(birthDateInLocal.plusYears(year).plusMonths(month), currentDate);
        return String.format("%s was born %d year, %d month, %d day", name, year, month, day);
    }

    @SuppressWarnings({"deprecation", "removal"})
    @Override
    protected void finalize() {
        System.out.println("Human object is being removed: " + this.getName() + " " + this.getSurname());
    }


    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formattedBirthDate = sdf.format(Date.from(Instant.ofEpochMilli(birthDate)));
        return String.format("{name='%s', surname='%s', birthDate='%s', iq=%d, schedule=%s}",
                name, surname, formattedBirthDate, iq, schedule != null ? schedule.toString() : "null");
    }

}
