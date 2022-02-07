package teaching.java.runtime_complexity.page1;

import java.util.Arrays;
import java.util.Random;

/** Answers to question 10 from <a href="https://86d98cb5-ca6b-4f81-9ecd-6350645ed93b.filesusr.com/ugd/0535b1_07d3374bfe024c25a7aeeaa02363e33d.pdf">this page</a>.
 * @implNote
 * 	<ul>
 * 		<li>Write a method which receives as its argument an array of grades
 * 		(each grade is an int in the range [0, 100].</br>
 * 		This method would return the grades' median.</li>
 * 	</ul>
 * @author Grizzly McBear
 */
public class Question10 {

	private static final int MAX_GRADE = 100;
	
	public static void main(String[] args) {
		int[] randomGrades = generateRandomGrades(50);
		System.out.println(String.format("Grades are: %s", Arrays.toString(randomGrades)));
		System.out.println(String.format("Median of grades is: %f", findMedianGrade(randomGrades)));
	}
	
	/** This helper method generates an array of random grades.
	 * @param gradesAmount The amount of grades to generate.
	 * @return Array of random grades, each one is of type `int` and in the range [0, 100] (inclusive).
	 */
	private static int[] generateRandomGrades(int gradesAmount) {
		Random random = new Random();
		
		// Create an array with the desired length.
		int[] grades = new int[gradesAmount];
		
		// Iterate and generate random grade for each item in the previous array.
		for (int gradeIndex = 0; gradeIndex < gradesAmount; gradeIndex++) {
			grades[gradeIndex] = random.nextInt(MAX_GRADE + 1);// Random value in the range [0, 100]
		}
		
		return grades;
	}
	
	/** Solution to question 10, sub-section a
	 * @implNote This solution uses the logic from <a href="https://www.mathsisfun.com/median.html">this</a> article.
	 * @param grades Array containing `int` grades. 
	 * @return The median grade for the given grades.
	 */
	public static double findMedianGrade(int[] grades) {
		int amountForMedian = grades.length + 1;
		int[] countedGrades = countGrades(grades);
		
		if (amountForMedian % 2 == 0)
			return getGradeByPosition(countedGrades, amountForMedian / 2);
		else
			return 0.5 * (getGradeByPosition(countedGrades, amountForMedian / 2) + getGradeByPosition(countedGrades, 1 + amountForMedian / 2));
	}
	
	/** This method returns an array in which each item is the amount of grades equal to it. */
	private static int[] countGrades(int[] grades) {
		/* Define an array in which each item is the amount of students who got that grade.
		 * Note: all items are initialized with 0. */
		int[] gradesCount = new int [101];
		
		for (int gradeIndex = 0; gradeIndex < grades.length; gradeIndex++) {
			/* Shorter and more complex solution:
			gradesCount[grades[gradeIndex]]++;
			*/
			
			/* Same solution, divided into more steps: */
			int currGrade = grades[gradeIndex];
			gradesCount[currGrade]++;
		}
		
		return gradesCount;
	}

	/** Returns the grade in the requested position.
	 * @param countedGrades An array in which each item is the amount of existing grades.
	 * @param position The requested position (ordered) of the grade.
	 * @return
	 * @implNote There are 2 cases for the grades amounts here which are actually the same:
	 * 	<ul>
	 * 		<li>Grades distribution is: ...[position]...</br>
	 * 		where [position] represents only 1 grade.</li>
	 * 		<li>Grades distribution is: ...[position]...</br>
	 * 		where [position] represents more than 1 grade.</li>
	 * 	</ul></br>
	 * Either way - the grade in the requested position is the same.
	 */
	private static int getGradeByPosition(int[] countedGrades, int position) {
		int traversedGradesAmount = 0;
		int gradeIndex = 0;
		
		while (traversedGradesAmount < position && gradeIndex < countedGrades.length) {
			traversedGradesAmount += countedGrades[gradeIndex];
			gradeIndex++;
		}
		
		return gradeIndex - 1;
	}
}
