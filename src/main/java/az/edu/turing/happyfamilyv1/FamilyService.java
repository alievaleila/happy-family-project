package az.edu.turing.happyfamilyv1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FamilyService {

    private FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        List<Family> families = getAllFamilies();
        for (int i = 0; i < families.size(); i++) {
            System.out.println(i + ": " + families.get(i));
        }
    }

    public List<Family> getFamiliesBiggerThan(int peopleCount) {
        return familyDao.getFamiliesBiggerThan(peopleCount);
    }

    public List<Family> getFamiliesLessThan(int peopleCount) {
        return familyDao.getFamiliesLessThan(peopleCount);
    }

    public int countFamiliesWithMemberNumber(int peopleCount) {
        return familyDao.countFamiliesWithMemberNumber(peopleCount);
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

    public void deleteChildrenOlderThen(int age) {
        familyDao.deleteChildrenOlderThen(age);
    }

    public int count() {
        return familyDao.count();
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyById(index);
    }

    public Set<Pet> getPets(int index) {
        Family family = familyDao.getFamilyById(index);
        return family != null ? new HashSet<>(family.getPets()) : new HashSet<>();
    }


    public boolean addPet(int index, Pet pet) {
        Family family = getFamilyById(index);
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
