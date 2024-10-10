package az.edu.turing.happyfamilyv1;

import java.util.Arrays;
import java.util.Objects;

public class Family {

    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    public Family(Human mother, Human father, Human[] children) {
        this.mother = mother;
        this.father = father;
        this.children = children;
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

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void deleteChild(Human child) {
        if (children != null) {
            children = Arrays.stream(children)
                    .filter(c -> !c.equals(child))
                    .toArray(Human[]::new);
        }
    }

    public boolean deleteChild(int index) {
        if (index >= 0 && index < children.length) {
            Human[] newChildren = new Human[children.length - 1];
            for (int i = 0, j = 0; i < children.length; i++) {
                if (i != index) {
                    newChildren[j++] = children[i];
                }
            }
            children = newChildren;
            return true;
        }
        return false;
    }

    public void addChild(Human child) {
        if (children == null) {
            children = new Human[]{child};
        } else {
            Human[] newChildren = Arrays.copyOf(children, children.length + 1);
            newChildren[newChildren.length - 1] = child;
            children = newChildren;
        }
        child.setFamily(this);
    }

    public int countFamily() {
        return 2 + (children != null ? children.length : 0);
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Family object is being removed.");
        } finally {
            super.finalize();
        }
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + Arrays.toString(children) +
                ", pet=" + pet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && Objects.deepEquals(children, family.children) && Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, Arrays.hashCode(children), pet);
    }
}
