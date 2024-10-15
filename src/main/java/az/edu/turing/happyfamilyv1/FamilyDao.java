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

    Family createNewFamily(Human mother, Human father);

    Family adoptChild(Family family, Human child);

    void deleteChildrenOlderThen(int age);

    int count();

    boolean addPet(int index, Pet pet);
}
