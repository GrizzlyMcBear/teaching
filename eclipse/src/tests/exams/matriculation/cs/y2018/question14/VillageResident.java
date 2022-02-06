package tests.exams.matriculation.cs.y2018.question14;

public class VillageResident extends Resident {
    
	private static final double DISCOUNT_RATE = 0.1;
    /**
     * Returns the property tax after discount for a village resident.
     */
    public double getPropertyTax() {
        double initialTax = super.getPropertyTax();
        
        return initialTax * (1 - DISCOUNT_RATE);
    }

    public VillageResident() {
        super();
    }
    
    public VillageResident(String name) {
        super(name);
    }
}