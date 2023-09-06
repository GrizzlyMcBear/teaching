package teaching.java.unit4.recursion.tail;

public class ReversePrintNumber {
    public static String iterativeReturn(int number) {
        // Initialize variables
        int copy = number;
        int digitsAmount = 1;

        // Find amount of digits
        for (; copy >= 10; digitsAmount++) {
            copy /= 10;
        }

        // Copy digits into newly created array
        int[] digits = new int[digitsAmount];
        for (int i = 0; i < digitsAmount; i++) {
            digits[i] = number % 10;
            number /= 10;
        }

        // Print the number
        String output = digits[0] + "";
        for (int i = 1; i < digitsAmount; i++) {
            output += digits[i];
        }

        //System.out.print(output);
        return output;
    }

    public static void iterativePrint(int number) {
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

    public static void recursivePrint(int number) {
        // Stopping condition
        if (number < 10) {
            System.out.print(number);
        } else {
            System.out.print(number % 10);
            recursivePrint(number / 10);
        }
    }

    public static String recursiveReturn(int number) {
        // Stopping condition
        if (number < 10) {
            return "" + number;
        } else {
            return "" + (number % 10) + recursiveReturn(number / 10);
        }
    }
}
