package unit4.ADT.classes.HashMap.helpers.values;

public class Guitar extends Instrument {
    private int cords;

    public Guitar(String color, int cords) {
        super(color);
        setCords(cords);
    }

    public int getCords() {
        return cords;
    }

    public void setCords(int cords) {
        this.cords = cords;
    }

    @Override
    public String toString() {
        return String.format("Guitar (%s, cords: %d)", super.toString(), getCords());
    }
}
