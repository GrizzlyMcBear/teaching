package teaching.java.unit1_2.array.multidim.primitives.presentation.questions;

import java.util.Scanner;

public class Solutions {
    public static void main(String[] args) {
        hardcodedSizedMatrix();
    }

    public static void hardcodedSizedMatrix() {
        // Declare helpers
        Scanner scanner = new Scanner(System.in);
        final int NUM_CLASSES = 3;
        final int STUDENTS_IN_CLASS = 5;

        // Allocate and initialize array
        int[][] grades = new int[NUM_CLASSES][STUDENTS_IN_CLASS];

        System.out.println("Please enter grades for students in classes:");// Instruct the user of what is to be
        for (int i = 0; i < grades.length; i++)  {// Iterate over all rows (classes)
            System.out.print("Please enter grades for students in class #" + (i+1) + ": ");// Ask the user for information

            for (int j = 0; j < grades[i].length; j++) {// Iterate on all students for the current class
                grades[i][j] = scanner.nextInt();// Read input from keyboard and insert to proper matrix cell
            }
        }

        // Print the stored information, same principles in the nested for loop
        System.out.println("The grades in all classes:");
        for (int i = 0; i < grades.length; i++)  {
            System.out.print("Class #" + (i+1) + ": ");
            for (int j = 0; j < grades[i].length; j++) {
                System.out.print(grades[i][j] + " ");
            }
            System.out.println();
        }
    }
}