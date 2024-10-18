package az.edu.turing.happyfamilyv1;

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
        return familyDao.createNewFamily(mother, father);
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
        int nowYear = LocalDate.now().getYear();
        familyList.forEach(family -> {
            List<Human> olderChildren = family.getChildren().stream()
                    .filter(child -> (nowYear - child.getBirthDate()) <= age)
                    .collect(Collectors.toList());
            family.setChildren(olderChildren);
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
        return familyDao.addPet(index, pet);
    }

    public boolean deleteFamily(Family family) {
        return familyDao.deleteFamily(family);
    }
}
