package az.edu.turing.happyfamilyv1;

public class Main {

    public static void main(String[] args) {


        Pet dog = new Dog("Buddy", 5, 80, new String[]{"run", "fetch"});
        Pet cat = new DomesticCat("Whiskers", 3, 70, new String[]{"sleep", "scratch"});
        Pet roboCat = new RoboCat("Tom", 1, 90, new String[]{"beep", "scan"});
        Pet fish = new Fish("Nemo", 2, 30, new String[]{"swim", "hide"});

        System.out.println(dog);
        System.out.println(cat);
        System.out.println(roboCat);
        System.out.println(fish);

        Man man = new Man("John", "Doe", 1985);
        Woman woman = new Woman("Jane", "Doe", 1990);

        Family family = new Family(man, woman, new Human[0]);
        family.setPet(dog);

        man.setFamily(family);
        woman.setFamily(family);

        man.greetPet();
        man.repairCar();

        woman.greetPet();
        woman.makeup();

        dog.respond();
        ((Foul) dog).foul();
    }
}