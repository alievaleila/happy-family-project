package az.edu.turing.happyfamilyv1;

import java.util.List;

public interface FamilyDao {

    List<Family> getAllFamilies();

    Family getFamilyById(int index);

    boolean deleteFamily(int index);

    boolean deleteFamily(Family family);

    void saveFamily(Family family);

    void displayAllFamilies();

    List<Family> getFamiliesBiggerThan(int peopleCount);

    List<Family> getFamiliesLessThan(int peopleCount);

    int countFamiliesWithMemberNumber(int peopleCount);

    void createNewFamily(Human mother, Human father);

    Family bornChild(Family family, String maleName, String femaleName);

    Family adoptChild(Family family, Human child);

    void deleteChildrenOlderThen(int age);

    int count();

    List<Pet> getPets(int index);

    void addPet(int index, Pet pet);
}
