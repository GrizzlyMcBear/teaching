package teaching.java.oop.inheritance.copy_constructor;

import teaching.java.oop.inheritance.copy_constructor.points.*;

public class Main {

	public static void main(String[] args) {
		PointXY point0 = new PointXY(1, 2);
		PointXYZ point1 = new PointXYZ(0, 0, 0);
		PointXYZ point2 = new PointXYZ(point1);
		PointXY point3 = new PointXY(point2);
		/* Question 1: would the following code compile/run with no issues?
		PointXYZ point4 = new PointXYZ(point3);
		*/
		
		// Printing initial points:
		System.out.println(String.format("point0 = %s", point0.toString()));
		System.out.println(String.format("point1 = %s", point1.toString()));
		System.out.println(String.format("point2 = %s", point2.toString()));
		System.out.println(String.format("point3 = %s", point3.toString()));
		
		// Updating value and printing points:
		point1.setX(15.15);
		System.out.println(String.format("point1 = %s", point1.toString()));
		System.out.println(String.format("point2 = %s", point2.toString()));
	}
}