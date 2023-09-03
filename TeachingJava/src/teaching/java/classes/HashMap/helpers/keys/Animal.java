package teaching.java.classes.HashMap;

public class Animal {
    private String name;
    private int age;

    public Animal() {
        this("N/A", 0);
    }
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("Animal (name: %s, age: %d)", name, age);
    }
}
