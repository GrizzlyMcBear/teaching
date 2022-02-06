package eclipse.tests.exams.internal._2022_01_27.Question1;

public class Utils {

	public static Point[] createPoints(String csvData) {
		String[] rawPoints = csvData.split(":");
		Point[] points = new Point[rawPoints.length];
		String[] pairValues = null;
		
		for(int index = 0; index < rawPoints.length; index++) {
			pairValues = rawPoints[index].split(",");
			points[index] = new Point(Double.parseDouble(pairValues[0]), Double.parseDouble(pairValues[1]));
		}
		
		return points;
	}
}
