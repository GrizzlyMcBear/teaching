package teaching.java.classes.HashMap.helpers.values;

public class Instrument {
    private String color;

    public Instrument() {
        this("N/A");
    }

    public Instrument(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Instrument (color: %s)", getColor());
    }
}