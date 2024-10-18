package az.edu.turing.happyfamilyv1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Pet dog = new Dog("Oskar", 5, 80, new String[]{"run", "fetch"});
        Pet cat = new DomesticCat("Whiskers", 3, 70, new HashSet<>(Arrays.asList("sleep", "scratch")));
        Pet roboCat = new RoboCat("Tom", 1, 90, new String[]{"beep", "scan"});
        Pet fish = new Fish("Nemo", 2, 30, new HashSet<>(Arrays.asList("swim", "hide")));

        System.out.println(dog);
        System.out.println(cat);
        System.out.println(roboCat);
        System.out.println(fish);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            long fatherBirthDate = dateFormat.parse("15/08/1985").getTime();
            long motherBirthDate = dateFormat.parse("20/10/1990").getTime();

            Man father = new Man("John", "Doe", (int) fatherBirthDate);
            Woman mother = new Woman("Jane", "Doe", (int) motherBirthDate);

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

            System.out.println(father.getName() + "'s age: " + father.describeAge());
            System.out.println(mother.getName() + "'s age: " + mother.describeAge());

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

            long child1BirthDate = dateFormat.parse("10/09/2004").getTime();
            long child2BirthDate = dateFormat.parse("15/05/2006").getTime();

            Human child1 = new Human("Kevin", "Karlene", child1BirthDate, 90, scheduleChild1);
            Human child2 = new Human("Anna", "Karlene", child2BirthDate, 95, scheduleChild2);

            familyController.createNewFamily(mother, father);
            Family family2 = familyController.getFamilyById(0);

            familyController.addPet(0, dog);

            familyController.adoptChild(family, child1);
            familyController.adoptChild(family, child2);

            mother.greetPet();
            mother.describePet();
            mother.makeup();

            father.greetPet();
            father.describePet();
            father.repairCar();

            child1.greetPet();
            child1.describePet();

            System.out.println(child1.getName() + "'s age: " + child1.describeAge());
            System.out.println(child2.getName() + "'s age: " + child2.describeAge());

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

            long adoptedChildBirthDate = dateFormat.parse("20/03/2010").getTime();
            Human adoptedChild = new Human("Lily", "Karlene", adoptedChildBirthDate, 100, Map.of(
                    DayOfWeek.FRIDAY, "Art class",
                    DayOfWeek.SATURDAY, "Swimming"
            ));
            familyController.adoptChild(family, adoptedChild);
            familyController.displayAllFamilies();

            familyController.deleteChildrenOlderThen(18);
            familyController.displayAllFamilies();

            Family retrievedFamily = familyController.getFamilyById(0);
            System.out.println(retrievedFamily != null ? retrievedFamily : "No family found at the specified index.");

            Set<Pet> petsOfFamily = familyController.getPets(0);
            System.out.println(!petsOfFamily.isEmpty() ? petsOfFamily : "No pets found for the specified family.");

            familyController.addPet(0, roboCat);
            familyController.displayAllFamilies();

            boolean isDeleted = familyController.deleteFamilyByIndex(0);
            System.out.println("Family deleted: " + isDeleted);
            familyController.displayAllFamilies();

            boolean isDeletedNonExistent = familyController.deleteFamilyByIndex(1);
            System.out.println("Family deleted: " + isDeletedNonExistent);

            familyController.displayAllFamilies();

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
