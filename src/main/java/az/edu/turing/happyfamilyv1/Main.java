package az.edu.turing.happyfamilyv1;

public class Main {

    public static void main(String[] args) {
        Pet pet1 = new Pet("dog", "Spike", 5, 75, new String[]{"eat", "drink", "sleep"});
        Pet pet2 = new Pet("cat", "Poke", 2, 41, new String[]{"climb", "scratch"});
        Pet pet3 = new Pet("eager", "Nomi", 7, 61, new String[]{"fly", "eat"});

        System.out.println(pet1);
        System.out.println(pet2);
        System.out.println(pet3);

        Human mother = new Human("Marry", "Karlene", 1976);
        Human father = new Human("Tom", "Karlene", 1971);
        Human child = new Human("Kevin", "Karlene", 2004, 90, pet1, mother, father, new String[][]{
                {"Monday", "Go to work"},
                {"Tuesday", "Go to school"},
        });

        System.out.println(child);

        child.greetPet();
        child.describePet();
        pet1.eat();
        pet1.respond();
        pet1.foul();
    }
}
