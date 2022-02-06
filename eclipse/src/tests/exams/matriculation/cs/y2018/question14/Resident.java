package tests.exams.matriculation.cs.y2018.question14;

public class Resident implements IData {
    
	// Might be `protected`
    private String name;

    private double propertyTax = 0.0;

    private int age;
    
    public static final double RESIDENTIAL_TAX_RATE = 10;

    public static final double BASIC_TAX_RATE = 0.5;

    private double residentialArea = 0;

    private double basicArea = 0;

    public String getName() {
        return this.name;
    }

    public double getPropertyTax() {
        return this.propertyTax;
    }

    private void updatePropertyTax() {
        this.propertyTax = (residentialArea * RESIDENTIAL_TAX_RATE) + (basicArea * BASIC_TAX_RATE);
    }

    public double getResidentialArea() {
        return this.residentialArea;
    }

    public void setResidentialArea(double value) {
        if (value >= 0) {
            this.residentialArea = value;
            updatePropertyTax();
        }
    }

    public double getBasicArea() {
        return this.basicArea;
    }

    public void setBasicArea(double value) {
        if (value >= 0) {
            this.basicArea = value;
            updatePropertyTax();
        }
    }

    public int getAge() {
        return this.age;
    }

    public Resident() {
        this.name = "John Doe";
    }

    public Resident(String name) {
        if (name.isEmpty()) {
            this.name = "John Doe";
        } else {
            this.name = name;
        }
    }
}