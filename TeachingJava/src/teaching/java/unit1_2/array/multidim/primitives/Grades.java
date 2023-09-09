package teaching.java.unit1_2.array.multidim.primitives;
public class Grades {
    public static void scenario1() {
        float[] biologyGrades = new float[24];

        System.out.println("The biology grades are:");
        for (int i = 0; i < biologyGrades.length; i++) {
            System.out.print(biologyGrades[i] + ", ");
        }
    }
}
