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
    private Human mother;
    private Human father;
    private Human child1;
    private Human child2;
    private Pet pet;

    @BeforeEach
    public void setUp() {
        mother = new Human("Agatha", "Christie", 1985);
        father = new Human("Jack", "London", 1972);
        child1 = new Human("Martin", "Eden", 2000);
        child2 = new Human("Fyodor", "Dostoyevski", 2010);
        pet = new Pet(Species.DOG, "Rock", 3, 55, new String[]{"eat", "drink", "sleep"});
        family = new Family(mother, father, new Human[]{child1, child2});
        family.setPet(pet);
    }

    @Test
    public void testAddChild() {
        Human newChild = new Human("Hercule", "Poirot", 2006);
        family.addChild(newChild);
        assertEquals(3, family.getChildren().length);
        assertEquals(newChild, family.getChildren()[2]);
    }


    @Test
    public void testDeleteChildByIndex() {
        assertTrue(family.deleteChild(1));
        assertArrayEquals(new Human[]{child1}, family.getChildren());
    }

    @Test
    public void testDeleteChildInvalidIndex() {
        assertFalse(family.deleteChild(5));
    }

    @Test
    public void testCountFamily() {
        assertEquals(4, family.countFamily());
        family.addChild(new Human("New Child", "Test", 2021));
        assertEquals(5, family.countFamily());
    }
}



