package teaching.java.classes.HashMap.helpers.values;

public class Drums extends Instrument {
    private boolean isElectronic;

    public Drums(String color, boolean isElectronic) {
        super(color);
        setElectronic(isElectronic);
    }

    public boolean isElectronic() {
        return isElectronic;
    }

    public void setElectronic(boolean electronic) {
        isElectronic = electronic;
    }

    @Override
    public String toString() {
        return String.format("Drums (%s, is electronic: %b)", super.toString(), isElectronic());
    }
}
