package az.edu.turing.happyfamilyv1;

public class Main {

    public static void main(String[] args) {

        Pet pet1 = new Pet(Species.DOG, "Rock", 3, 55, new String[]{"eat", "drink", "sleep"});
        Pet pet2 = new Pet("cat", "Poke");
        Pet pet3 = new Pet("eager", "Nomi", 7, 61, new String[]{"fly", "eat"});

        System.out.println(pet1);
        System.out.println(pet2);
        System.out.println(pet3);

        System.out.println("111");
        System.out.println(pet1.getSpecies());


        Human mother = new Human("Marry", "Karlene", 1976);
        Human father = new Human("Tom", "Karlene", 1971);
        Human child = new Human("Kevin", "Karlene", 2004, 90, new Family(mother, father, new Human[3]), new String[][]{
                {"Monday", "Go to work"},
                {"Tuesday", "Go to school"},
        });

        String[][] schedule = {
                {DayOfWeek.MONDAY.name(), "Go to work"},
                {DayOfWeek.TUESDAY.name(), "Go to school"},
                {DayOfWeek.WEDNESDAY.name(), "Go shopping"},
                {DayOfWeek.THURSDAY.name(), "Go to gym"},
                {DayOfWeek.FRIDAY.name(), "Family time"},
                {DayOfWeek.SATURDAY.name(), "Relax"},
                {DayOfWeek.SUNDAY.name(), "Prepare for the week"}
        };


        System.out.println(child);

        child.greetPet();
        child.describePet();
        pet3.eat();
        pet3.respond();
        pet3.foul();

        long maxMemory = Runtime.getRuntime().maxMemory();
        long freeMemory;

        int count = 0;
        while (true) {
            Human human = new Human();

            count++;

            freeMemory = Runtime.getRuntime().freeMemory();

            if (count % 1000 == 0) {
                System.out.println("Created " + count + " Human objects. Free memory: " + freeMemory / (1024 * 1024) + " MB");
            }

            if (freeMemory < maxMemory * 0.1) {
                System.out.println("Memory limit reached. Stopping object creation.");
                break;
            }
        }


    }
}
