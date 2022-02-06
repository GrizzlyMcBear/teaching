package tests.exams.matriculation.cs.y2018.question14;

public class SeniorCityResident extends CityResident {
    
    private static final int DISCOUNT_BASE_AGE = 60;
    
    private static final double EXTRA_DISCOUNT = 0.01;

    /**
     * Returns the property tax after cumulative discount for a senior city resident.
     */
    public double getPropertyTax() {
        double tax = super.getPropertyTax();
        int seniorityYears = super.getAge() - DISCOUNT_BASE_AGE;
        
        if (seniorityYears > 0)
        	tax = tax - tax * EXTRA_DISCOUNT * seniorityYears;
        
        return tax;
    }

    public SeniorCityResident() {
        super();
    }
    
    public SeniorCityResident(String name) {
        super(name);
    }
}