package eclipse.tests.exams.internal.recursion.q_01;

import java.util.Arrays;

/**
 * @author Ronen Cohen
 * @implNote This code is based on <a href="https://www.geeksforgeeks.org/recursive-selection-sort/">this webpage</a>.
 */
public class New {

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	private static int minIndex(int[] a, int i, int j) {
	    if (i == j)
	        return i;
	 
	    // Find minimum of remaining elements
	    int k = minIndex(a, i + 1, j);
	 
	    // Return minimum of current and remaining.
	    return (a[i] < a[k])? i : k;
	}
	private static void recurSelectionSort(int[] a, int n, int index) {

		if (index == n)
			return;

		int k = minIndex(a, index, n-1);

		if (k != index)
			swap(a, k, index);

		recurSelectionSort(a, n, index + 1);
	}

	public static void test() {
		int[] input = new int[] { 3, 1, 5, 2, 7, 0 };
		System.out.println(Arrays.toString(input));
		recurSelectionSort(input, input.length, 0);
		System.out.println(Arrays.toString(input));
	}
}
