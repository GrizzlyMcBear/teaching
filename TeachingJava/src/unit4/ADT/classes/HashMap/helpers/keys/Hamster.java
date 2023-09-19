package unit4.ADT.classes.HashMap.helpers.keys;

public class Hamster extends Animal {
    private String likedFood;

    public Hamster(String name, int age, String likedFood) {
        super(name, age);
        setLikedFood(likedFood);
    }

    public String getLikedFood() {
        return likedFood;
    }

    public void setLikedFood(String likedFood) {
        this.likedFood = likedFood;
    }

    @Override
    public String toString() {
        return String.format("Hamster (%s, likedFood: %s)", super.toString(), likedFood);
    }
}