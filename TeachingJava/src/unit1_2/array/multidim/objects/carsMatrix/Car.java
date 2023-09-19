package teaching.java.unit1_2.classes.teaching.java.unit1_2.array.multidim.objects.carsMatrix;

public class Car {

    // Properties
    private String brand;
    private double price;
    private String license;

    // Getters and Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand != null && !brand.isEmpty())
            this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        if (license != null && !license.isEmpty())
            this.license = license;
    }

    // Constructors
    public Car() {
        this("None", 1.234, "00-000-00");
    }

    public Car(String brand, double price, String license) {
        setBrand(brand);
        setPrice(price);
        setLicense(license);
    }

    public Car(Car car) {
        setBrand(car.getBrand());// Copy the reference for the previous brand
        setPrice(car.getPrice());// Copy the prev price (value)
        setLicense(new String(car.getLicense()));// Create a new string object but with the same content
    }

    // Other methods
    //@Override
    //public String toString(int faux) {
    public String toString() {
        return String.format("Brand: %s, Price: $%f, License number: %s", getBrand(), getPrice(), getLicense());
    }
}
