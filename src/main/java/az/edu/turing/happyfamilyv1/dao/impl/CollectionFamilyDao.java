package az.edu.turing.happyfamilyv1.dao.impl;

import az.edu.turing.happyfamilyv1.entity.Family;
import az.edu.turing.happyfamilyv1.entity.Human;
import az.edu.turing.happyfamilyv1.dao.FamilyDao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionFamilyDao implements FamilyDao {

    private List<Family> families = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyById(int index) {
        if (index >= 0 && index < families.size()) {
            return families.get(index);
        }
        return null;
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index >= 0 && index < families.size()) {
            families.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return families.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        if (family == null) {
            throw new IllegalArgumentException("Family cannot be null");
        }

        int index = families.indexOf(family);
        if (index == -1) {
            families.add(family);
            System.out.println("Added new family: " + family);
        } else {
            families.set(index, family);
            System.out.println("Updated existing family at index " + index + ": " + family);
        }
    }

    @Override
    public List<Family> getFamiliesBiggerThan(int peopleCount) {
        return getAllFamilies().stream().filter(f -> f.countFamily() > peopleCount).collect(Collectors.toList());
    }

    @Override
    public List<Family> getFamiliesLessThan(int peopleCount) {
        return getAllFamilies().stream().filter(f -> f.countFamily() < peopleCount).collect(Collectors.toList());
    }

    @Override
    public long countFamiliesWithMemberNumber(long peopleCount) {
        return (long) getAllFamilies().stream().filter(f -> f.countFamily() == peopleCount).count();
    }

    @Override
    public Family adoptChild(Family family, Human child) {
        family.addChild(child);
        saveFamily(family);
        return family;
    }

    @Override
    public void deleteChildrenOlderThen(int age) {
        int currentYear = LocalDate.now().getYear();
        for (Family family : getAllFamilies()) {
            family.getChildren().removeIf(child -> (currentYear - child.convertMillisLocalDate(child.getYear()).getYear()) > age);
            saveFamily(family);
        }
    }

    @Override
    public int count() {
        return getAllFamilies().size();
    }
    @Override
    public void loadData(List<Family> newFamilies) {
        this.families = newFamilies;
    }

    public void saveDataToFile(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(families);
            System.out.println("Families have been saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadDataFromFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            families = (List<Family>) in.readObject();
            System.out.println("Families have been loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
