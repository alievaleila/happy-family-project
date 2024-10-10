package az.edu.turing.happyfamilyv1;

public class Main {

    public static void main(String[] args) {
        Pet pet1 = new Pet();
        Pet pet2 = new Pet("cat", "Poke");
        Pet pet3 = new Pet("eager", "Nomi", 7, 61, new String[]{"fly", "eat"});

       System.out.println(pet1);
        System.out.println(pet2);
        System.out.println(pet3);

        Human mother = new Human("Marry", "Karlene", 1976);
        Human father = new Human("Tom", "Karlene", 1971);
        Human child = new Human("Kevin", "Karlene", 2004, 90, pet3, mother, father, new String[][]{
                {"Monday", "Go to work"},
                {"Tuesday", "Go to school"},
        });

        System.out.println(child);

        child.greetPet();
        child.describePet();
        pet3.eat();
        pet3.respond();
        pet3.foul();
    }
}
