package az.edu.turing.happyfamilyv1;

import java.util.List;
import java.util.Set;

public class FamilyController {

    private FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int peopleCount) {
        return familyService.getFamiliesBiggerThan(peopleCount);
    }

    public List<Family> getFamiliesLessThan(int peopleCount) {
        return familyService.getFamiliesLessThan(peopleCount);
    }

    public int countFamiliesWithMemberNumber(int peopleCount) {
        return familyService.countFamiliesWithMemberNumber(peopleCount);
    }

    public Family createNewFamily(Human mother, Human father) {
        return familyService.createNewFamily(mother, father);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyService.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family family, String maleName, String femaleName) {
        return familyService.bornChild(family, maleName, femaleName);
    }

    public Family adoptChild(Family family, Human child) {
        return familyService.adoptChild(family, child);
    }

    public void deleteChildrenOlderThen(int age) {
        familyService.deleteChildrenOlderThen(age);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int index) {
        return familyService.getFamilyById(index);
    }

    public Set<Pet> getPets(int index) {
        return familyService.getPets(index);
    }

    public boolean addPet(int index, Pet pet) {
        return familyService.addPet(index, pet);
    }

    public boolean deleteFamily(Family family) {
        return familyService.deleteFamily(family);
    }
}
