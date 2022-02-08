package teaching.java.oop.inheritance.copy_constructor.points;

/**
 * This class represents a point in the 2 dimensional Cartesian space. 
 * @author Grizzly McBear
 */
public class PointXY {

	/**
	 * The x value of this point.
	 */
	protected double x;
	
	/**
	 * The y value of this point.
	 */
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
	
	/**
	 * C'tor with {@link PointXY#x} and {@link PointXY#y} arguments.
	 * @param x The {@link PointXY#x} value.
	 * @param y The {@link PointXY#y} value.
	 */
	public PointXY(double x, double y) {
		super();
		setX(x);
		setY(y);
	}
	
	/**
	 * A copy-constructor for this {@link PointXY}
	 * @param other A {@link PointXY} argument.
	 */
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