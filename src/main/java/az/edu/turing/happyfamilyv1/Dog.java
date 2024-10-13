package az.edu.turing.happyfamilyv1;

public class Dog extends Pet implements Foul {

    public Dog(String nickname,int age,int trickLevel,String [] habits) {

        super(Species.DOG,nickname,age,trickLevel,habits);
    }
    @Override
    public void respond() {
        System.out.println("Woof! I am a dog named"+getNickname());
    }
    @Override
    public void foul() {
        System.out.println("Oops! I made a mess");
    }
}
