package tests.exams.matriculation.cs.y2018.question14;

public class CityResident extends Resident {

	private static final int DISCOUNT = 250;
	
    /**
     * Returns the property tax after discount for a regular city resident.
     */
    public double getPropertyTax() {
    	double tax = super.getPropertyTax();
    	tax -= DISCOUNT;
    	
    	if (tax < 0)
    		tax = 0;
        
    	return tax;

    	/* Another option:
         double propertyTax = Math.max(super.getPropertyTax() - DISCOUNT, 0);
         return propertyTax;
         */
    }

    public CityResident() {
        super();
    }

    public CityResident(String name) {
        super(name);
    }
}