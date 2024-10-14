package az.edu.turing.happyfamilyv1;

import java.util.*;

public class Family {

    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pet;
    private HashSet<Pet> pets;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.pets = new HashSet<>();
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Set<Pet> getPet() {
        return pet;
    }

    public void setPet(Set<Pet> pet) {
        this.pet = pet;
    }

    public HashSet<Pet> getPets() {
        return pets;
    }

    public Optional<Human> deleteChild(int index) {
        if (index < 0 || index >= children.size()) {
            return Optional.empty();
        }
        return Optional.of(children.remove(index));
    }

    public boolean deleteChild(Human child) {
        return children.remove(child);
    }

    public List<Human> addChild(Human child) {
        if (child != null) {
            children.add(child);
        }
        return children;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public int countFamily() {
        return 2 + children.size();
    }

    @Override
    @Deprecated
    @SuppressWarnings("removal")
    protected void finalize() throws Throwable {
        System.out.println("Human object is being removed." + this);
    }


    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + children +
                ", pets=" + pet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father) &&
                Objects.deepEquals(children, family.children) &&
                Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children, pets);
    }
}
