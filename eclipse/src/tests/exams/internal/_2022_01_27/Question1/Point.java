package eclipse.tests.exams.internal._2022_01_27.Question1;

public class Point {

	private double _x;
	
	private double _y;
	
	public Point(double x, double y) {
		_x = x;
		_y = y;
	}
	
	public Point(Point p) {
		_x = p._x;
		_y = p._y;
	}
	
	public double getX() {
		return _x;
	}
	
	public double getY() {
		return _y;
	}
	
	public void setX(double x) {
		_x = x;
	}
	
	public void setY(double y) {
		_y = y;
	}

	@Override
	public String toString() {
		return String.format("(%.2f, %.2f)", _x, _y);
	}
}