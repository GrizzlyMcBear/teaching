package unit4.ADT.classes.HashMap.helpers.values;

public class Instrument {

    // Properties
    private String color;

    // Setters and Getters
    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        if (color != null && !color.isEmpty())
            this.color = color;
    }

    // Constructors
    public Instrument(String color) {
        setColor(color);
    }
}