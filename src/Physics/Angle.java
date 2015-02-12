package Physics;

/**
 * Contains methods for working with angles.
 * @author Ian
 *
 */
public class Angle {
	/**
	 * Converts an angle in degrees to radians.
	 * @param angle The angle in degrees.
	 * @return The angle in radians.
	 */
	public static double toRadians(double angle) {
		return angle * (Math.PI / 180);
	}
	
	/**
	 * Converts an angle in radians to degrees.
	 * @param angle The angle in radians.
	 * @return The angle in degrees.
	 */
	public static double toDegrees(double angle) {
		return angle * (180 / Math.PI);
	}
	
	/*public double degrees;
	public double rads;
	
	public Angle(double angle) {
		degrees = angle;
		rads = angle * (Math.PI / 180);
	}
	
	public double asRadians() {
		return rads;
	}
	
	public double asDegrees() {
		return 
	}*/
}
