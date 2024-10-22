package az.edu.turing.happyfamilyv1;

import az.edu.turing.happyfamilyv1.dao.impl.CollectionFamilyDao;
import az.edu.turing.happyfamilyv1.dao.entity.Dog;
import az.edu.turing.happyfamilyv1.dao.entity.DomesticCat;
import az.edu.turing.happyfamilyv1.dao.entity.Family;
import az.edu.turing.happyfamilyv1.dao.entity.Human;
import az.edu.turing.happyfamilyv1.dao.entity.Man;
import az.edu.turing.happyfamilyv1.dao.entity.Pet;
import az.edu.turing.happyfamilyv1.dao.entity.Woman;
import az.edu.turing.happyfamilyv1.service.FamilyService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CollectionFamilyDao familyDao = new CollectionFamilyDao();
        FamilyService familyService = new FamilyService(familyDao);
        Scanner scanner = new Scanner(System.in);

        String filename = "src/main/resources/families.json";

        if (familyService.getAllFamilies().isEmpty()) {
            createTestFamilies(familyDao);
        }

        while (true) {
            System.out.println("\n--- Family Management System ---");
            System.out.println("1. Display all families");
            System.out.println("2. Save families to JSON file");
            System.out.println("3. Load families from JSON file");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    familyService.displayAllFamilies();
                    break;
                case 2:
                    familyService.saveData(filename);
                    System.out.println("Families saved to JSON file.");
                    break;
                case 3:
                    familyService.loadData(filename);
                    familyService.displayAllFamilies();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createTestFamilies(CollectionFamilyDao familyDao) {
        Human mother1 = new Woman("Lisa", "Smith", LocalDate.of(1990, 5, 20), 100);
        Human father1 = new Man("Mike", "Smith", LocalDate.of(1988, 3, 15), 110);
        Family family1 = new Family(mother1, father1);

        Human child1 = new Human("Emily", "Smith", LocalDate.of(2015, 4, 10), 95);
        Human child2 = new Human("James", "Smith", LocalDate.of(2017, 8, 22), 98);
        family1.addChild(child1);
        family1.addChild(child2);

        Pet dog1 = new Dog("Buddy", 3, 75, new String[]{"barking", "fetching", "playing"});
        Pet cat1 = new DomesticCat("Whiskers", 2, 60, new String[]{"scratching", "napping"});
        family1.addPet(dog1);
        family1.addPet(cat1);

        familyDao.saveFamily(family1);

        Human mother2 = new Woman("Kate", "Johnson", LocalDate.of(1992, 6, 12), 105);
        Human father2 = new Man("John", "Johnson", LocalDate.of(1990, 8, 22), 115);
        Family family2 = new Family(mother2, father2);

        Human child3 = new Human("Sophia", "Johnson", LocalDate.of(2016, 9, 5), 90);
        family2.addChild(child3);

        Pet cat2 = new DomesticCat("Mittens", 4, 50, new String[]{"purring", "playing"});
        family2.addPet(cat2);

        familyDao.saveFamily(family2);
    }
}
