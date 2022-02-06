package eclipse.tests.exams.internal._2022_01_27.Question1;

public class SectionB {

	public static void main(String[] args) {
		testSolution("3,5:4,5:8,5:-2,7:4,7");
	}
	
	/**
	 * @implNote This isn't the most efficient solution -
	 * we're told that the points in the array are sorted (for each line i.e. Y value)
	 * in an increasing order of their X values.
	 * @implSpec This solution's runtime efficiency is O(N) as we go over the entire array.
	 * However we could improve it to O(log(N)) -
	 * if we add a binary search to find the last point on the lower line. 
	 * @param p
	 * @return
	 */
	public static Rectangle smallestRect2(Point[] p) {
		// These two values I know for sure
		double smallestY = p[0].getY();
		double largestY = p[p.length - 1].getY();
		
		// These two values are an assumption and might be updated later on
		double smallestX = p[0].getX();
		double largestX = p[p.length - 1].getX();
		
		// Find the smallest and largest X values for any point in the array
		for (int index = 1; index < p.length; index++) {
			if (p[index].getX() < smallestX) smallestX = p[index].getX();
			else if (p[index].getX() > largestX) largestX = p[index].getX();
		}
		
		// Calculate the rectangle's c'tor arguments
		double height = largestY - smallestY;
		double width = largestX - smallestX;
		Point sw = new Point(smallestX, smallestY);
		
		return new Rectangle(height, width, sw);
	}
	
	private static void testSolution(String csvPoints) {
		Point[] points = Utils.createPoints(csvPoints);
		Rectangle rect = smallestRect2(points);
		System.out.println(String.format("For these points: %s\nThis is the smallest wrapper rectangle: %s", csvPoints, rect.toString()));
	}
}
