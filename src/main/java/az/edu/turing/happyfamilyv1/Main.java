package az.edu.turing.happyfamilyv1;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        Pet dog = new Dog("Buddy", 5, 80, new String[]{"run", "fetch"});
        Pet cat = new DomesticCat("Whiskers", 3, 70, new HashSet<>(Arrays.asList("sleep", "scratch")));
        Pet roboCat = new RoboCat("Tom", 1, 90, new String[]{"beep", "scan"});
        Pet fish = new Fish("Nemo", 2, 30, new HashSet<>(Arrays.asList("swim", "hide")));

        System.out.println(dog);
        System.out.println(cat);
        System.out.println(roboCat);
        System.out.println(fish);

        Man father = new Man("John", "Doe", 1985);
        Woman mother = new Woman("Jane", "Doe", 1990);

        Family family = new Family(father, mother);
        Set<Pet> pets = new HashSet<>();
        pets.add(dog);
        pets.add(cat);

        family.setPet(pets);


        father.setFamily(family);
        mother.setFamily(family);

        father.greetPet();
        father.repairCar();

        mother.greetPet();
        mother.makeup();

        dog.respond();
        ((Foulable) dog).foul();

        System.out.println("-----part 6-----");
        FamilyDao familyDao = new CollectionFamilyDao();
        FamilyService familyService = new FamilyService(familyDao);
        FamilyController familyController = new FamilyController(familyService);

        Map<DayOfWeek, String> scheduleChild1 = new HashMap<>();
        scheduleChild1.put(DayOfWeek.MONDAY, "Go to work");
        scheduleChild1.put(DayOfWeek.TUESDAY, "Go to school");

        Map<DayOfWeek, String> scheduleChild2 = new HashMap<>();
        scheduleChild2.put(DayOfWeek.WEDNESDAY, "Dance class");
        scheduleChild2.put(DayOfWeek.THURSDAY, "Piano lessons");

        Human child1 = new Human("Kevin", "Karlene", 2004, 90, scheduleChild1);
        Human child2 = new Human("Anna", "Karlene", 2006, 95, scheduleChild2);

        familyController.createNewFamily(mother, father);
        Family family2 = familyController.getFamilyById(0);

        familyController.addPet(0, dog);

        familyController.adoptChild(family, child1);
        familyController.adoptChild(family, child2);

//        familyController.displayAllFamilies();

        mother.greetPet();
        mother.describePet();
        mother.makeup();

        father.greetPet();
        father.describePet();
        father.repairCar();

        child1.greetPet();
        child1.describePet();

        int familiesCount = familyController.count();
        System.out.println("Total families: " + familiesCount);

        List<Family> allFamilies = familyController.getAllFamilies();
        System.out.println("All Families:");
        for (Family fam : allFamilies) {
            System.out.println(fam);
        }

        List<Family> bigFamilies = familyController.getFamiliesBiggerThan(3);
        System.out.println("Families bigger than 3 members:");
        for (Family fam : bigFamilies) {
            System.out.println(fam);
        }

        List<Family> smallFamilies = familyController.getFamiliesLessThan(3);
        System.out.println("Families less than 3 members:");
        for (Family fam : smallFamilies) {
            System.out.println(fam);
        }

        int familiesWith4 = familyController.countFamiliesWithMemberNumber(4);
        System.out.println("Number of families with exactly 4 members: " + familiesWith4);

        familyController.bornChild(family, "Alex", "Emily");
        familyController.displayAllFamilies();

        Human adoptedChild = new Human("Lily", "Karlene", 2010, 100, Map.of(
                DayOfWeek.FRIDAY, "Art class",
                DayOfWeek.SATURDAY, "Swimming"
        ));
        familyController.adoptChild(family, adoptedChild);
        familyController.displayAllFamilies();

        familyController.deleteChildrenOlderThen(18);
        familyController.displayAllFamilies();

        Family retrievedFamily = familyController.getFamilyById(0);
        System.out.println(retrievedFamily != null ? retrievedFamily : "No family found at the specified index.");

        List<Pet> petsOfFamily = familyController.getPets(0);
        System.out.println(!petsOfFamily.isEmpty() ? petsOfFamily : "No pets found for the specified family.");

        familyController.addPet(0, roboCat);
        familyController.displayAllFamilies();

        boolean isDeleted = familyController.deleteFamilyByIndex(0);
        System.out.println("Family deleted: " + isDeleted);
        familyController.displayAllFamilies();

        boolean isDeletedNonExistent = familyController.deleteFamilyByIndex(1);
        System.out.println("Family deleted: " + isDeletedNonExistent);

        familyController.displayAllFamilies();
    }
}