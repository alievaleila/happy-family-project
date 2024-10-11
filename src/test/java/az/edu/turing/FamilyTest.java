package az.edu.turing;


import az.edu.turing.happyfamilyv1.Family;
import az.edu.turing.happyfamilyv1.Human;
import az.edu.turing.happyfamilyv1.Pet;
import az.edu.turing.happyfamilyv1.Species;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FamilyTest {
    private Family family;
    private Human human;
    private Human mother;
    private Human father;
    private Human child1;
    private Human child2;
    private Human child3;
    private Pet pet;

    @BeforeEach
    public void setUp() {
        Human mother = new Human("Agatha", "Christie", 1985);
        father = new Human("Jack", "London", 1972);
        child1 = new Human("Martin", "Eden", 2000);
        child2 = new Human("Fyodor", "Dostoyevski", 2010);
        child3 = new Human("Hercule", "Puoro", 2006);
        pet = new Pet(Species.DOG, "Rock", 3, 55, new String[]{"eat", "drink", "sleep"});
        family = new Family(mother, father, family.getChildren());
        ;
        family.setChildren(new Human[]{child1, child2});
        family.setPet(pet);
    }

    @Test
    public void deleteChildWithIndexSuccessTest() {
        assertTrue(family.deleteChild(0));
        Human[] oneChild = family.getChildren();
        assertEquals(1, oneChild.length);
        assertEquals(child2, oneChild[0]);
    }


    @Test
    public void deleteChildWithObjectSuccessTest() {
        assertTrue(family.deleteChild(child2));
        Human[] oneChild = family.getChildren();
        assertEquals(1, oneChild.length);
        assertEquals(child1, oneChild[0]);
    }


    @Test
    public void addChildTest() {
        family.addChild(child3);
        assertEquals(3, family.getChildren().length);
        family.addChild(null);
        assertEquals(3, family.getChildren().length);
    }

    @Test
    public void countFamilyTest() {
        assertEquals(4, family.getChildren().length + 2);
        family.addChild(child3);
        assertEquals(5, family.getChildren().length + 2);
        family.addChild(null);
        assertEquals(5, family.getChildren().length + 2);
        family.deleteChild(1);
        assertEquals(4, family.getChildren().length + 2);
        family.deleteChild(child3);
        assertEquals(3, family.getChildren().length + 2);
        family.deleteChild(null);
        assertEquals(3, family.getChildren().length + 2);
    }

    @Test
    public void testToString() {
        String expected = "Family{" +
                "mother=" + mother.toString() +
                ", father=" + father.toString() +
                ", children=" + Arrays.toString(new Human[]{child1, child2}) +
                ", pet=" + pet.toString() + '}';

        assertEquals(expected, family.toString());
    }
}

