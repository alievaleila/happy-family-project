package az.edu.turing.entity;


import az.edu.turing.happyfamilyv1.dao.entity.Family;
import az.edu.turing.happyfamilyv1.dao.entity.Human;
import az.edu.turing.happyfamilyv1.dao.entity.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class FamilyTest {

    private Family family;
    private Human mother;
    private Human father;
    private Human child1;
    private Human child2;
    private Human child3;
    private Set<Pet> pets;

    @BeforeEach
    void setUp() {
        mother = new Human("Agatha", "Christie", 1985);
        father = new Human("Jack", "London", 1972);
        child1 = new Human("Martin", "Eden", 2000);
        child2 = new Human("Fyodor", "Dostoyevski", 2010);

        family = new Family(mother, father);
        family.addChild(child1);
        family.addChild(child2);


        pets = new HashSet<>();
        family.setPet(pets);
    }

    @Test
    void testAddChild() {
        Human newChild = new Human("Hercule", "Poirot", 2006);
        family.addChild(newChild);
        assertEquals(3, family.getChildren().size());
        assertEquals(newChild, family.getChildren().get(2));
        ;
    }

    @Test
    void deleteChildByObjectTest() {
        assertTrue(family.deleteChild(child2));
        List<Human> remainingChildren = family.getChildren();
        assertEquals(1, remainingChildren.size());
        assertEquals(child1, remainingChildren.get(0));
    }


    @Test
    void testCountFamily() {
        assertEquals(4, family.countFamily());
        family.addChild(new Human("New Child", "Test", 2021));
        assertEquals(5, family.countFamily());
    }
}



