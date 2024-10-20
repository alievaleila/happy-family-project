package az.edu.turing.happyfamilyv1;

import az.edu.turing.happyfamilyv1.controller.FamilyController;
import az.edu.turing.happyfamilyv1.dao.FamilyDao;
import az.edu.turing.happyfamilyv1.dao.impl.CollectionFamilyDao;
import az.edu.turing.happyfamilyv1.entity.*;
import az.edu.turing.happyfamilyv1.exception.FamilyOverFlowException;
import az.edu.turing.happyfamilyv1.service.FamilyService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FamilyDao familyDao = new CollectionFamilyDao();
        FamilyService familyService = new FamilyService(familyDao);
        FamilyController familyController = new FamilyController(familyService);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Family Management System!");

        while (true) {
            displayMenu();
            String command = scanner.nextLine().trim();

            switch (command) {
                case "1":
                    familyService.fillWithTestData();
                    break;

                case "2":
                    familyController.displayAllFamilies();
                    break;

                case "3":
                    System.out.println("Enter the minimum number of family members:");
                    int minPeopleCount = Integer.parseInt(scanner.nextLine());
                    familyController.getFamiliesBiggerThan(minPeopleCount);
                    break;

                case "4":
                    System.out.println("Enter the maximum number of family members:");
                    int maxPeopleCount = Integer.parseInt(scanner.nextLine());
                    familyController.getFamiliesLessThan(maxPeopleCount);
                    break;

                case "5":
                    System.out.println("Enter the exact number of family members:");
                    int exactPeopleCount = Integer.parseInt(scanner.nextLine());
                    long count = familyController.countFamiliesWithMemberNumber(exactPeopleCount);
                    System.out.println("Number of families with exactly " + exactPeopleCount + " members: " + count);
                    break;

                case "6":
                    createNewFamily(scanner, familyController);
                    break;

                case "7":
                    System.out.println("Enter the family ID to delete:");
                    int familyId = Integer.parseInt(scanner.nextLine());
                    boolean deleted = familyController.deleteFamilyByIndex(familyId);
                    System.out.println(deleted ? "Family deleted." : "Family not found.");
                    break;

                case "8":
                    editFamily(scanner, familyController);
                    break;

                case "9":
                    System.out.println("Enter the age limit for removing children:");
                    int age = Integer.parseInt(scanner.nextLine());
                    familyController.deleteChildrenOlderThen(age);
                    break;

                case "exit":
                    System.out.println("Exiting the application...");
                    return;

                default:
                    System.out.println("Invalid command, please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nAvailable commands: ");
        System.out.println("1. Fill with test data");
        System.out.println("2. Display the entire list of families");
        System.out.println("3. Display families with more than a specified number of members");
        System.out.println("4. Display families with fewer than a specified number of members");
        System.out.println("5. Count families with a specified number of members");
        System.out.println("6. Create a new family");
        System.out.println("7. Delete a family by its index");
        System.out.println("8. Edit a family");
        System.out.println("9. Remove all children over a certain age");
        System.out.println("Type 'exit' to quit.");
        System.out.print("Enter a command: ");
    }

    private static void createNewFamily(Scanner scanner, FamilyController familyController) {
        try {
            System.out.println("Enter mother's name:");
            String motherName = scanner.nextLine();
            System.out.println("Enter mother's last name:");
            String motherLastName = scanner.nextLine();
            System.out.println("Enter mother's birth year:");
            int motherBirthYear = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter mother's month of birth:");
            int motherBirthMonth = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter mother's birthday:");
            int motherBirthDay = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter mother's IQ:");
            int motherIq = Integer.parseInt(scanner.nextLine());

            Human mother = new Woman(motherName, motherLastName, motherBirthYear, motherBirthMonth, motherBirthDay, motherIq);

            System.out.println("Enter father's name:");
            String fatherName = scanner.nextLine();
            System.out.println("Enter father's last name:");
            String fatherLastName = scanner.nextLine();
            System.out.println("Enter father's birth year:");
            int fatherBirthYear = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter father's month of birth:");
            int fatherBirthMonth = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter father's birthday:");
            int fatherBirthDay = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter father's IQ:");
            int fatherIq = Integer.parseInt(scanner.nextLine());

            Human father = new Man(fatherName, fatherLastName, fatherBirthYear, fatherBirthMonth, fatherBirthDay, fatherIq);

            familyController.createNewFamily(mother, father);
            System.out.println("New family created successfully.");
        } catch (Exception e) {
            System.out.println("Error creating family: " + e.getMessage());
        }
    }

    private static void editFamily(Scanner scanner, FamilyController familyController) {
        System.out.println("Enter the family ID to edit:");
        int familyId = Integer.parseInt(scanner.nextLine());

        System.out.println("1. Give birth to a baby");
        System.out.println("2. Adopt a child");
        System.out.println("3. Return to main menu");
        System.out.print("Enter a command: ");
        String command = scanner.nextLine().trim();

        switch (command) {
            case "1":
                System.out.println("Enter the boy's name:");
                String boyName = scanner.nextLine();
                System.out.println("Enter the girl's name:");
                String girlName = scanner.nextLine();
                try {
                    familyController.bornChild(familyController.getFamilyById(familyId), boyName, girlName);
                    System.out.println("Child born successfully.");
                } catch (FamilyOverFlowException e) {
                    System.out.println("Cannot add child: " + e.getMessage());
                }
                break;

            case "2":
                System.out.println("Enter the child's first name:");
                String childName = scanner.nextLine();
                System.out.println("Enter the child's last name:");
                String childSurname = scanner.nextLine();
                System.out.println("Enter the child's year of birth:");
                int childBirthYear = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the child's IQ:");
                int childIq = Integer.parseInt(scanner.nextLine());

                Human adoptedChild = new Human(childName, childSurname, childBirthYear, childIq);
                familyController.adoptChild(familyController.getFamilyById(familyId), adoptedChild);
                System.out.println("Child adopted successfully.");
                break;

            case "3":
                System.out.println("Returning to main menu.");
                break;

            default:
                System.out.println("Invalid command.");
        }
    }
}
