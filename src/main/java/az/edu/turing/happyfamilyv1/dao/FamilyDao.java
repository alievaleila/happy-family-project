package az.edu.turing.happyfamilyv1.dao;

import az.edu.turing.happyfamilyv1.entity.Family;
import az.edu.turing.happyfamilyv1.entity.Human;

import java.util.List;

public interface FamilyDao {

    List<Family> getAllFamilies();

    Family getFamilyById(int index);

    boolean deleteFamily(int index);

    boolean deleteFamily(Family family);

    void saveFamily(Family family);

    List<Family> getFamiliesBiggerThan(int peopleCount);

    List<Family> getFamiliesLessThan(int peopleCount);

    long countFamiliesWithMemberNumber(long peopleCount);

    Family adoptChild(Family family, Human child);

    void deleteChildrenOlderThen(int age);

    int count();

    void loadData(List<Family> families);
}
