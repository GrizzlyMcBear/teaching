package teaching.java.oop.inheritance.copy_constructor.points;

public class PointXY {

	protected double x;
	
	protected double y;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public PointXY(double x, double y) {
		super();
		setX(x);
		setY(y);
	}
	
	public PointXY(PointXY other) {
		super();
		setX(other.getX());
		// This would work even if 'y' is private
		y = other.y;
	}
	
	@Override
	public String toString() {
		return String.format("X = %.2f, Y = %.2f", x, y);
	}
}