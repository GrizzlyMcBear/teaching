package eclipse.tests.exams.internal._2022_01_27.Question1;

// TODO: add link to this exam's form.
/**
 * This is the solution for the 1st sub-section of question 1 in the exam which took place on the 2022.01.27
 * @author Ronen Cohen
 */
public class SectionA {
	
	public static void main(String[] args) {
		testSolution("1,1");
		testSolution("-1,-1:1,1");
		testSolution("-1,-1:1.1,1");
		testSolution("1,2:2,1:3,3");
	}
	
	public static Rectangle smallestRect1(Point[] p) {
		
		// Define edge values
		double smallestX = p[0].getX();
		double largestX = smallestX;
		double smallestY = p[0].getY();
		double largestY = smallestY;
		
		// Find the given points array edge values 
		for (int index = 1; index < p.length; index++) {
			if (p[index].getX() < smallestX) smallestX = p[index].getX();
			else if (p[index].getX() > largestX) largestX = p[index].getX();
			if (p[index].getY() < smallestY) smallestY = p[index].getY();
			else if (p[index].getY() > largestY) largestY = p[index].getY();
			
			// Another option:
//			smallestX = Math.min(p[index].getX(), smallestX);
//			largestX = Math.max(p[index].getX(), largestX);
//			smallestY = Math.min(p[index].getY(), smallestY);
//			largestY = Math.max(p[index].getY(), largestY);
		}
		
		// Calculate the rectangle's c'tor arguments
		double height = largestY - smallestY;
		double width = largestX - smallestX;
		Point sw = new Point(smallestX, smallestY);
		
		return new Rectangle(height, width, sw);
	}
	
	private static void testSolution(String csvPoints) {
		Point[] points = Utils.createPoints(csvPoints);
		Rectangle rect = smallestRect1(points);
		System.out.println(String.format("For these points: %s\nThis is the smallest wrapper rectangle: %s", csvPoints, rect.toString()));
	}
}