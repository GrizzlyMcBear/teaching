package teaching.java.unit4.recursion.tail;

public class ReversePrint {
    public static String iterativeSolutionReturn(int number) {
        // Initialize variables
        int copy = number;
        int digitsAmount = 0;

        // Find amount of digits
        for (; copy != 0; digitsAmount++) {
            copy /= 10;
        }

        // Copy digits into newly created array
        int[] digits = new int[digitsAmount];
        for (int i = digitsAmount - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        // Print the number
        String output = "";
        for (int i = 0; i < digitsAmount; i++) {
            output += digits[i];
        }

        //System.out.print(output);
        return output;
    }

    public static void iterativeSolutionPrint(int number) {
        // Initialize variables
        int copy = number;
        int digitsAmount = 0;

        // Find amount of digits
        for (; copy != 0; digitsAmount++) {
            copy /= 10;
        }

        // Copy digits into newly created array
        int[] digits = new int[digitsAmount];
        for (int i = digitsAmount - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        // Print the number
        String output = "";
        for (int i = 0; i < digitsAmount; i++) {
            output += digits[i];
        }

        System.out.print(output);
    }

    public static String recursiveSolutionPrint(int number) {
        // Stopping condition
        if (number < 10) {
            System.out.print(number);
        } else {
            System.out.print(number % 10);
            recursiveSolutionPrint(number / 10);
        }
    }
}
