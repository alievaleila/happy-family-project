package az.edu.turing.happyfamilyv1.service;

import az.edu.turing.happyfamilyv1.dao.FamilyDao;
import az.edu.turing.happyfamilyv1.entity.Family;
import az.edu.turing.happyfamilyv1.entity.Human;
import az.edu.turing.happyfamilyv1.entity.Man;
import az.edu.turing.happyfamilyv1.entity.Pet;
import az.edu.turing.happyfamilyv1.entity.Woman;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FamilyService {

    private FamilyDao familyDao;


    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public void saveData(String filename) {
        List<Family> families = familyDao.getAllFamilies();
        System.out.println("Families to save: " + families);

        if (families.isEmpty()) {
            System.out.println("No families to save.");
            return;
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(families, writer);
            System.out.println("Family data saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadData(String filename) {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(filename)) {
            Family[] families = gson.fromJson(reader, Family[].class);

            familyDao.getAllFamilies().clear();
            for (Family family : families) {
                familyDao.saveFamily(family);
            }
            System.out.println("Family data loaded from " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayFamilies() {
        List<Family> families = getAllFamilies();
        for (int i = 0; i < families.size(); i++) {
            System.out.println((i + 1) + ". " + families.get(i).prettyFormat());
        }
    }


    public List<Family> getFamiliesBiggerThan(Integer peopleCount) {
        return getAllFamilies().stream()
                .filter(family -> family.countFamily() > peopleCount)
                .collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(Integer peopleCount) {
        return getAllFamilies().stream()
                .filter(family -> family.countFamily() < peopleCount)
                .collect(Collectors.toList());
    }

    public Long countFamiliesWithMemberNumber(Integer peopleCount) {
        return familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() == peopleCount)
                .count();
    }

    public Family createNewFamily(Human mother, Human father) {
        Family newFamily = new Family(mother, father);
        familyDao.saveFamily(newFamily);
        return newFamily;
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String maleName, String femaleName) {
        int currentYear = LocalDate.now().getYear();
        boolean isBoy = Math.random() < 0.5;
        String childrenName = isBoy ? maleName : femaleName;
        double childrenIq = Math.random();

        Human child = isBoy ? new Man(childrenName, family.getFather().getSurname(), currentYear, childrenIq)
                : new Woman(childrenName, family.getFather().getSurname(), currentYear);

        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, Human child) {
        return familyDao.adoptChild(family, child);
    }

    public void deleteChildrenOlderThen(int age) {
        List<Family> familyList = getAllFamilies();
        Integer nowYear = LocalDate.now().getYear();
        familyList.forEach(family -> {
            family.getChildren().removeIf(child -> (nowYear - child.getYear()) > age);
        });
    }

//    public void fillWithTestData() {
//        Human mother1 = new Human("Kate", "Bibo", 1991, 3, 3, 95);
//        Human father1 = new Human("Karl", "Bibo", 1990, 12, 10, 90);
//        Family family1 = new Family(mother1, father1);
//        family1.addChild(new Human("Donna", "Bibo", 2018, 10, 23, 92));
//        family1.addChild(new Human("Sun", "Bibo", 2018, 10, 23, 92));
//        Set<String> dogHabits = new HashSet<>(List.of("sleep"));
//        Pet dog = new Dog("Jack", 3, 3, dogHabits);
//        family1.addPet(dog);
//        familyDao.saveFamily(family1);
//
//        Human mother2 = new Human("Lisa", "Smith", 1993, 4, 15, 100);
//        Human father2 = new Human("Mike", "Smith", 1990, 2, 8, 88);
//        Family family2 = new Family(mother2, father2);
//        family2.addChild(new Human("John", "Smith", 2015, 1, 1, 95));
//        Set<String> catHabits = new HashSet<>(List.of("eat", "play"));
//        Pet cat = new DomesticCat("Oscar", 5, 81, catHabits);
//        family2.addPet(cat);
//        familyDao.saveFamily(family2);
//
//        System.out.println("Test data successfully added.");
//    }

    public int count() {
        return familyDao.count();
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyById(index);
    }

    public List<Pet> getPets(int index) {
        Family family = familyDao.getFamilyById(index);
        return family != null ? new ArrayList<>(family.getPets()) : new ArrayList<>();
    }


    public void displayAllFamilies() {
        List<Family> families = getAllFamilies();
        IntStream.range(0, families.size()).forEach(i -> System.out.println((i + 1) + ". " + families.get(i)));
    }


    public boolean addPet(int index, Pet pet) {
        Family family = familyDao.getFamilyById(index);
        if (family != null) {
            family.addPet(pet);
            familyDao.saveFamily(family);
            return true;
        }
        return false;
    }

    public boolean deleteFamily(Family family) {
        return familyDao.deleteFamily(family);
    }

    public void loadData(List<Family> families) {
        familyDao.loadData(families);
    }
}
