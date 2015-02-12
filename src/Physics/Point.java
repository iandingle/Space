package Physics;

/**
 * Represents a point in r2.
 * @author Ian
 *
 */
public class Point {

	/**
	 * Adds to Points together.
	 * @param first A point to add.
	 * @param second Another point to add.
	 * @return
	 */
	public static Point add(Point first, Point second) {
		return new Point(first.getX() + second.getX(), first.getY() + second.getY());
	}
	
	/**
	 * Subtracts one Point from another.
	 * @param first The point to subtract from.
	 * @param second The point to subtract.
	 * @return
	 */
	public static Point subtract(Point first, Point second) {
		return new Point(first.getX() - second.getX(), first.getY() - second.getY());
	}
	
	private double x;
	private double y;
	
	/**
	 * Creates a new Instance of a Point at (0, 0).
	 */
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * Creates a new Point at the specified (x, y) coordinates.
	 * @param x The x coordinate of the new point.
	 * @param y The y coordinate of the new point.
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Creates a new Point with the same coordinates of another specified Point.
	 * @param other
	 */
	public Point(Point other) {
		x = other.getX();
		y = other.getY();
	}
	
	
	/**
	 * Gets the x position of the point.
	 * @return A double that is the x position of the point.
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Gets the y position of the point.
	 * @return A double that is the y position of the point.
	 */
	public double getY() {
		return y;
	}

	/**
	 * Adds another point to this point, changing the position of this point.
	 * @param other The other point to add.
	 */
	public void add(Point other) {
		this.x += other.getX();
		this.y += other.getY();
	}
	
	/**
	 * Determines if this point is equal to another point.
	 * @param other The point to compare this one against.
	 * @return true if the x and y coordinates of the original are both the same as other; otherwise, false.
	 */
	public boolean equalTo(Point other) {
		return other.getX() == x && other.getY() == y;
	}
	
	/**
	 * Returns the cartesian distance between this Point and another specified point.
	 * @param other The point to get the distance from this point to.
	 * @return A double representing the distance bewteen the two points.
	 */
	public double distanceTo(Point other) {
		double x2 = other.getX();
		double y2 = other.getY();
		
		return Math.sqrt(((x - x2) * (x - x2)) + (y - y2) * (y - y2));
	}	
	
	/**
	 * Returns the angle, in degrees, between this point and another specified point.
	 * @param other The other point to get the angle between.
	 * @return A double representing the degrees, in radians, between the two points.
	 */
	public double angleTo(Point other) {
		return Angle.toDegrees(Math.atan2(other.getY() - y, other.getX() - x));
	}
}
