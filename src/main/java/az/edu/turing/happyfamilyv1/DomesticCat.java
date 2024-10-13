package az.edu.turing.happyfamilyv1;

public class DomesticCat extends Pet implements Foul {

    public DomesticCat(String nickname,int age,int trickLevel,String [] habits) {
        super(Species.DOMESTIC_CAT,nickname,age,trickLevel,habits);

    }

    @Override
    public void respond() {
        System.out.println("DomesticCat " + getNickname() + " says: Meow meow!");
    }

    @Override
    public void foul() {
        System.out.println("I scratched the sofa!");
    }
}

