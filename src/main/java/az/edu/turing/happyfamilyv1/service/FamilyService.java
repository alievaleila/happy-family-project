package az.edu.turing.happyfamilyv1.service;

import az.edu.turing.happyfamilyv1.entity.Family;
import az.edu.turing.happyfamilyv1.entity.Human;
import az.edu.turing.happyfamilyv1.entity.Man;
import az.edu.turing.happyfamilyv1.entity.Pet;
import az.edu.turing.happyfamilyv1.entity.Woman;
import az.edu.turing.happyfamilyv1.dao.FamilyDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {

    private FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyDao.getAllFamilies()
                .forEach(System.out::println);
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

        Human child = isBoy ? new Man(childrenName, family.getFather().getSurname(), currentYear)
                : new Woman(childrenName, family.getFather().getSurname(), currentYear);

        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, Human child) {
        return familyDao.adoptChild(family, child);
    }

    public void deleteChildrenOlderThen(Integer age) {
        List<Family> familyList = getAllFamilies();
        Integer nowYear = LocalDate.now().getYear();
        familyList.forEach(family -> {
            family.getChildren().removeIf(child -> (nowYear - child.getBirthDate()) > age);
        });
    }

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
}
