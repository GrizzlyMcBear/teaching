package tests.exams.internal._2022_01_27.Question1;

public class Rectangle {

	private double _length;
	
	private double _width;
	
	private Point _sw;
	
	public Rectangle(double l, double w, Point sw) {
		_length = l;
		_width = w;
		_sw = new Point(sw);
	}

	public double get_length() {
		return _length;
	}

	public void set_length(double _length) {
		this._length = _length;
	}

	public double get_width() {
		return _width;
	}

	public void set_width(double _width) {
		this._width = _width;
	}

	public Point get_sw() {
		return _sw;
	}

	public void set_sw(Point _sw) {
		this._sw = _sw;
	}
	
	@Override
	public String toString() {
		return String.format("Rectangle [length = %.2f, width = %.2f, South-West = %s]", _length, _width, _sw.toString());
	}
}
