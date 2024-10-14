package az.edu.turing.happyfamilyv1;

import java.util.List;

public class FamilyService {

    private FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyDao.displayAllFamilies();
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

    public void createNewFamily(Human mother, Human father) {
        familyDao.createNewFamily(mother, father);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String maleName, String femaleName) {
        return familyDao.bornChild(family, maleName, femaleName);
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

    public List<Pet> getPets(int index) {
        return familyDao.getPets(index);
    }

    public void addPet(int index, Pet pet) {
        familyDao.addPet(index, pet);
    }

    public boolean deleteFamily(Family family) {
        return familyDao.deleteFamily(family);
    }
}
