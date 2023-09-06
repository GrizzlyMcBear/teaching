package teaching.java.classes.HashMap.helpers.keys;

public class Dog extends Animal {
    private String furColor;

    public Dog(String name, int age, String furColor) {
        super(name, age);
        setFurColor(furColor);
    }
    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    @Override
    public String toString() {
        return String.format("Dog (%s, furColor: %s)", super.toString(), furColor);
    }
}