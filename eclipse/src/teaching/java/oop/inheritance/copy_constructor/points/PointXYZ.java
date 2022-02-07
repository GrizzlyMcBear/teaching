package teaching.java.oop.inheritance.copy_constructor.points;

/**
 * This class represents a point in the 3 dimensional Cartesian space.
 * @author Grizzly McBear
 * @implSpec This class extends {@link PointXY}.
 */
public class PointXYZ extends PointXY {

	private double z;

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public PointXYZ(double x, double y, double z) {
		super(x, y);
		this.z = z;
	}
	
	public PointXYZ(PointXYZ other) {
		super(other);
		this.z = other.z;
	}

	@Override
	public String toString() {
		return String.format("%s, Z = %.2f", super.toString(), z);
	}
}
