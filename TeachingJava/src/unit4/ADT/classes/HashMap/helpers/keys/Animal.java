package unit4.ADT.classes.HashMap.helpers.keys;

public class Animal {

    // Properties
    private String name;
    private int age;

    // Constructors
    public Animal(String name, int age) {
        setAge(age);
        setName(name);
    }

    // Setters and Getters

    public void setAge(int age) {
        if (age >= 0) this.age = age;
    }
    public void setName(String name) {
        if (name != null && !name.isEmpty())
            this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public String getName() {
        return this.name;
    }
}