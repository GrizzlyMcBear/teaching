package teaching.java.classes.HashMap;

public class Cat extends Animal {
    private int numOfLives;

    public Cat(String name, int age, int numOfLives) {
        super(name, age);
        setNumOfLives(numOfLives);
    }

    public int getNumOfLives() {
        return numOfLives;
    }

    public void setNumOfLives(int numOfLives) {
        this.numOfLives = numOfLives;
    }

    @Override
    public String toString() {
        return String.format("Cat (%s, lives: %d)", super.toString(), numOfLives);
    }
}