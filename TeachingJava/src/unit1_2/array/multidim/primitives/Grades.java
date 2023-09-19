package teaching.java.unit1_2.classes.teaching.java.unit1_2.array.multidim.primitives;

import java.util.Date;
import java.util.Random;

public class Grades {
    public static void main(String[] args) {
        scenario4();
    }

    public static void scenario1() {
        // Declare a primitive array with default values
        int[] biologyGrades = new int[24];

        // Print those values
        System.out.println("The biology grades are:");
        for (int i = 0; i < biologyGrades.length; i++) {
            System.out.print(biologyGrades[i] + ", ");
        }
    }

    public static void scenario2() {
        // Declare a primitive array with default values
        int[] bioGrades = new int[24];

        // Insert actual (random) grades
        Random random = new Random((new Date()).getTime());
        for (int i = 0; i < bioGrades.length; i++) {
            bioGrades[i] = random.nextInt(101);
        }

        // Print those values
        System.out.println("The biology grades are:");
        for (int i = 0; i < bioGrades.length; i++) {
            System.out.print(bioGrades[i] + ", ");
        }
    }

    public static void scenario3() {
        // Declare a primitive array with default values
        int[] bioGradesGroup1 = new int[24];
        int[] bioGradesGroup2 = new int[24];

        // Insert actual (random) grades
        Random random = new Random((new Date()).getTime());
        for (int i = 0; i < bioGradesGroup1.length; i++) {
            bioGradesGroup1[i] = random.nextInt(101);
        }
        for (int i = 0; i < bioGradesGroup2.length; i++) {
            bioGradesGroup2[i] = random.nextInt(101);
        }

        // Print those values
        System.out.println("The biology grades for group 1 are:");
        for (int i = 0; i < bioGradesGroup1.length; i++) {
            System.out.print(bioGradesGroup1[i] + ", ");
        }
        System.out.println("The biology grades for group 2 are:");
        for (int i = 0; i < bioGradesGroup2.length; i++) {
            System.out.print(bioGradesGroup2[i] + ", ");
        }
    }

    public static void scenario4() {
        // Declare a primitive array with default values
        int[][] bioGroupsGrades = new int[17][24];

        // Insert actual (random) grades
        Random random = new Random((new Date()).getTime());
        for (int group = 0; group < bioGroupsGrades.length; group++) {
            for (int student = 0; student < bioGroupsGrades[group].length; student++) {
                bioGroupsGrades[group][student] = random.nextInt(101);
            }
        }

        // Print those values
        System.out.println("The biology grades by groups are:");
        for (int group = 0; group < bioGroupsGrades.length; group++) {
            System.out.println("\nFor group #" + (group + 1) + " :");
            for (int student = 0; student < bioGroupsGrades[group].length; student++) {
                System.out.print(bioGroupsGrades[group][student] + ", ");
            }
            System.out.println();
        }
    }

    public static void presentationExample() {
        int[][] nums;
        nums = new int[2][4];
        nums[1][2] = 3;
        System.out.println("nums[1][2] = " + nums[1][2]);
    }
}
