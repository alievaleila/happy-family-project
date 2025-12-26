package az.edu.turing.happyfamily.dao.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Family {

    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets;


    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.pets = new HashSet<>();
    }

    public Family(){

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
        return pets;
    }

    public void setPet(Set<Pet> pet) {
        this.pets = pet;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public String prettyFormat() {
        StringBuilder sb = new StringBuilder("family:\n");
        sb.append("\tmother: ").append(mother.prettyFormat()).append(",\n");
        sb.append("\tfather: ").append(father.prettyFormat()).append(",\n");
        sb.append("\tchildren:\n");
        for (Human child : children) {
            sb.append("\t\t").append(child.prettyFormat()).append("\n");
        }

        sb.append("\tpets:\n");
        for (Pet pet : pets) {
            sb.append("\t\t").append(pet.prettyFormat()).append("\n");
        }

        return sb.toString();
    }


    public Optional<Human> deleteChildByIndex(int index) {
        if (index < 0 || index >= children.size()) {
            return Optional.empty();
        }
        return Optional.of(children.remove(index));
    }

    public boolean deleteChild(Human child) {
        return children.remove(child);
    }

    public void addChild(Human child) {
        if (child == null) {
            throw new IllegalArgumentException("Child object cannot be null");
        }
        children.add(child);
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
        super.finalize();
    }

    @Override
    public String toString() {
        return String.format("Family{Mother=%s, Father=%s, Children=%s, Pets=%s}", mother, father, children, pets);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father) &&
                Objects.deepEquals(children, family.children) &&
                Objects.equals(pets, family.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children, pets);
    }
}
