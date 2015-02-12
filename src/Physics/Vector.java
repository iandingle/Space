package Physics;

/**
 * Represents a value with both magnitude and direction.
 * @author Ian
 *
 */
public class Vector {

	/**
	 * Adds two vectors together to get a new vector.
	 * @param first a vector to add.
	 * @param second Another vector to add.
	 * @return A new vector that is the sum of the two provided vectors.
	 */
	public static Vector add(Vector first, Vector second) {
		Vector dummy = new Vector(first);
		dummy.add(second);
		
		return dummy;
	}
	
	private double magnitude;
	private double direction;
	
	/**
	 * Creates a new instance of a vector with a specified magnitude and direction.
	 * @param mag The magnitude of the new vector.
	 * @param dir The direction of the new vector.
	 */
	public Vector(double mag, double dir) {
		magnitude = mag;
		direction = dir;
	}
	
	/**
	 * Creates a new vector that has the magnitude and direction of another vector.
	 * @param other The vector to copy.
	 */
	public Vector(Vector other) {
		magnitude = other.getMagnitude();
		direction = other.getDirection();	
	}
	
	/**
	 * Gets the magnitude of the vector.
	 * @return A double that is the magnitude of the vector.
	 */
	public double getMagnitude() {
		return magnitude;
	}
	
	/**
	 * Sets the magnitude of the vector.
	 * @param mag The new magnitude.
	 */
	public void setMagnitude(double mag) {
		magnitude = mag;
	}
	
	/**
	 * Gets the direction of the vector.
	 * @return A double that is the direction of the vector.
	 */
	public double getDirection() {
		return direction;
	}
	
	/**
	 * Sets the direction of the vector.
	 * @param dir The new direction.
	 */
	public void setDirection(double dir) {
		direction = dir;
	}
	
	/**
	 * Gets the X component of the vector.
	 * @return A double that is the X component of the vector.
	 */
	public double getX() {
		return magnitude * Math.cos(Angle.toRadians(direction));
	}
	
	/**
	 * Gets the Y Component of the vector.
	 * @return A double that is the Y component of the vector.
	 */
	public double getY() {
		return magnitude * Math.sin(Angle.toRadians(direction));
	}
	
	/**
	 * Adds another vector to this one.
	 * @param other The vector to add.
	 */
	public void add(Vector other) {
		double rx = getX() + other.getX();
		double ry = getY() + other.getY();
		
		double r = Math.sqrt((rx * rx) + (ry * ry));
		double angle = Math.atan2(ry, rx);
		
		magnitude = r;
		direction = Angle.toDegrees(angle);
	}
}
