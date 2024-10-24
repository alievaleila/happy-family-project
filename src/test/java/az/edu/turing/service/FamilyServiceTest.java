package az.edu.turing.service;


import az.edu.turing.happyfamilyv1.dao.FamilyDao;
import az.edu.turing.happyfamilyv1.dao.entity.Family;
import az.edu.turing.happyfamilyv1.dao.entity.Human;
import az.edu.turing.happyfamilyv1.dao.entity.Man;
import az.edu.turing.happyfamilyv1.dao.entity.Woman;
import az.edu.turing.happyfamilyv1.dao.impl.CollectionFamilyDao;
import az.edu.turing.happyfamilyv1.service.FamilyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FamilyServiceTest {

    private FamilyDao familyDao;
    private FamilyService familyService;


    @BeforeEach
    public void setUp() {
        familyDao = new CollectionFamilyDao();
        familyService = new FamilyService(familyDao);
    }

    @Test
    public void testCreateNewFamily() {
        Human mother = new Woman("Alice", "Smith", 1980);
        Human father = new Man("Bob", "Smith", 1980, 38);

        Family newFamily = familyService.createNewFamily(mother, father);

        assertNotNull(newFamily);
        assertEquals(mother.getName(), ((Family) newFamily).getMother().getName());
        assertEquals(father.getName(), newFamily.getFather().getName());
    }

    @Test
    public void testGetAllFamilies() {
        assertTrue(familyService.getAllFamilies().isEmpty());

        Human mother = new Woman("Alice", "Smith", 1980);
        Human father = new Man("Bob", "Smith", 1980, 38);
        familyService.createNewFamily(mother, father);

        List<Family> families = familyService.getAllFamilies();
        assertEquals(1, families.size());
    }

    @Test
    public void testDeleteFamilyByIndex() {
        Human mother = new Woman("Alice", "Smith", 1980);
        Human father = new Man("Bob", "Smith", 1980, 38);
        familyService.createNewFamily(mother, father);

        boolean result = familyService.deleteFamilyByIndex(0);
        assertTrue(result);
        assertTrue(familyService.getAllFamilies().isEmpty());
    }

    @Test
    public void testCountFamilies() {
        assertEquals(0, familyService.count());

        Human mother = new Woman("Alice", "Smith", 1980);
        Human father = new Man("Bob", "Smith", 1980, 38);
        familyService.createNewFamily(mother, father);

        assertEquals(1, familyService.count());
    }

    @Test
    public void testBornChild() {
        Family family = new Family(new Woman("Alice", "Smith", 1980),
                new Man("Bob", "Smith", 1980, 38));
        familyService.createNewFamily(family.getMother(), family.getFather());

        Family result = familyService.bornChild(family, "John", "Jane");
        assertEquals(1, result.getChildren().size());
    }

    @Test
    public void testAdoptChild() {
        Family family = familyService.createNewFamily(new Woman("Alice", "Smith", 1980),
                new Man("Bob", "Smith", 1980, 38));
        Human child = new Woman("Mary", "Doe", 2005);

        Family result = familyService.adoptChild(family, child);
        assertTrue(result.getChildren().contains(child));
    }

    @Test
    public void testGetFamiliesBiggerThan() {
        familyService.createNewFamily(new Woman("Alice", "Smith", 1980),
                new Man("Bob", "Smith", 1980, 38));
        familyService.bornChild(familyService.getAllFamilies().get(0), "John", "Jane");

        List<Family> result = familyService.getFamiliesBiggerThan(1);
        assertEquals(1, result.size());
    }


    @Test
    public void testCountFamiliesWithMemberNumber() {
        familyService.createNewFamily(new Woman("Alice", "Smith", 1980),
                new Man("Bob", "Smith", 1980, 38));
        familyService.bornChild(familyService.getAllFamilies().get(0), "John", "Jane");

        long count = familyService.countFamiliesWithMemberNumber(3);
        assertEquals(1, count);
    }

    @Test
    public void testGetFamilyById() {
        Family family = familyService.createNewFamily(new Woman("Alice", "Smith", 1980),
                new Man("Bob", "Smith", 1980, 38));

        Family result = familyService.getFamilyById(0);
        assertEquals(family, result);
    }

    @Test
    public void testDisplayAllFamilies() {
        Human mother = new Woman("Alice", "Smith", 1980);
        Human father = new Man("Bob", "Smith", 1980, 38);
        familyService.createNewFamily(mother, father);
        assertEquals(1, familyService.getAllFamilies().size());
        Family family = familyService.getAllFamilies().get(0);

        assertEquals("Alice", family.getMother().getName());
        assertEquals("Bob", family.getFather().getName());
    }

    @Test
    public void getFamiliesLessThan() {
        Human mother = new Woman("Alice", "Smith", 1980);
        Human father = new Man("Bob", "Smith", 1980, 38);
        Family family = familyService.createNewFamily(mother, father);

        Human mother2 = new Woman("Carol", "Jones", 1985);
        Human father2 = new Man("Dave", "Jones", 1985, 38);
        Family family2 = familyService.createNewFamily(mother2, father2);

        family.addChild(new Man("Ethan", "Smith", 2020, 38));
        List<Family> familiesLessThan3 = familyService.getFamiliesLessThan(3);

        assertEquals(1, familiesLessThan3.size());
        assertEquals(family2, familiesLessThan3.get(0));
    }

    @Test
    public void testDeleteChildrenOlderThen() {
        Human mother = new Woman("Alice", "Smith", 1980);
        Human father = new Man("Bob", "Smith", 1980, 38);
        Family family = familyService.createNewFamily(mother, father);


        family.addChild(new Man("Ethan", "Smith", 2015, 38));
        family.addChild(new Woman("Emma", "Smith", 2010));
        family.addChild(new Man("Liam", "Smith", 2005, 38));


        familyService.deleteChildrenOlderThen(15);


        Set<Human> remainingChildren = new HashSet<>(family.getChildren());
        assertEquals(2, remainingChildren.size());


        assertTrue(remainingChildren.stream().anyMatch(child -> child.getName().equals("Ethan")));
        assertTrue(remainingChildren.stream().anyMatch(child -> child.getName().equals("Emma")));
        assertFalse(remainingChildren.stream().anyMatch(child -> child.getName().equals("Liam")));
    }

}










