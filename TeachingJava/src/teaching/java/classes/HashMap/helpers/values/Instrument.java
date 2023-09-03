package teaching.java.classes.HashMap.helpers.values;

public class Instrument {
    private String name;

    public Instruments() {
        this("N/A");
    }

    public Instruments(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}