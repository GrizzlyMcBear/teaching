package teaching.java.unit1_2.array.multidim.objects.carsMatrix;

public class Example {
    public static void main(String[] args) {
        Car[][] cars;
        cars = new Car[2][4];
        cars[1][2] = new Car("Susita", 125000, "23-121-45");

        System.out.println("My car’s price after discount = " + cars[1][2].getPrice() * 0.95);
        System.out.println("Car’s details = " + cars[1][2]);
        System.out.println("Car’s details (toString) = " + cars[1][2].toString());
    }
}
