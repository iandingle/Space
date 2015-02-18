package Physics;

import java.awt.Graphics;

/**
 * Represents a free object capable of moving in space.
 * @author Ian
 *
 */
public abstract class FreeObject {
	private static final double minimumVelocity = 0.08;
	
	private Point position;
	private Vector velocity;
	private double mass;
	
	/**
	 * Creates a new instance of a FreeObject.
	 * @param position The initial position of the free object.
	 * @param velocity The initial velocity of the free object.
	 * @param mass The mass of the free object.
	 */
	public FreeObject(Point position, Vector velocity, double mass) {
		this.position = position;
		this.velocity = velocity;
		this.mass = mass;
	}
	
	/**
	 * Applies the velocity of this free object to its position.
	 */
	public void updatePosition() {
		if (velocity.getMagnitude() < minimumVelocity) {
			velocity.setMagnitude(0);
		}
		else {
			position.add(new Point(velocity.getX(), velocity.getY()));
		}
	}
	
	/**
	 * Applies the velocity of this free object to its position, affected by a specified scale.
	 * @param scale The scale to apply to the velocity.
	 */
	public void updatePosition(double scale) {
		if (velocity.getMagnitude() < minimumVelocity) {
			velocity.setMagnitude(0);
		}
		else {
			position.add(new Point(velocity.getX() * scale, velocity.getY() * scale));
		}
	}
	
	/**
	 * Exerts a force on this object.
	 * @param applied The force vector being applied.
	 */
	public void exertForce(Vector applied) {
		velocity.add(new Vector(applied.getMagnitude() / mass, applied.getDirection()));
		//forces.add(applied);
	}
	
	/**
	 * Exerts a force on this object.
	 * @param appMag The magnitude of the applied force.
	 * @param appDir The direction of the applied force.
	 */
	public void exertForce(double appMag, double appDir) {
		velocity.add(new Vector(appMag / mass, appDir));
		//forces.add(new Vector(appMag, appDir));
	}
	
	/**
	 * Gets the position of the free object.
	 * @return A Point object representing the position of the free object.
	 */
	public Point getPosition() {
		return new Point(position);
	}
	
	/**
	 * Gets the velocity of the free object.
	 * @return A Vector representing the velocity of the free object.
	 */
	public Vector getVelocity() {
		return new Vector(velocity);
	}
	
	/**
	 * Gets the mass of the free object.
	 * @return
	 */
	public double getMass() {
		return mass;
	}
	
	/**
	 * Sets the position of the free object.
	 * @param pos the new position to set.
	 */
	public void setPosition(Point pos) {
		position = new Point(pos);
	}
	
	/**
	 * Sets the velocity of the free object.
	 * @param vel the new velocity to set.
	 */
	public void setVelocity(Vector vel) {
		velocity = new Vector(vel);
	}
	
	/**
	 * Performs whatever actions are needed to draw this free object.
	 * @param g The Graphics object this will be drawn to.
	 */
	public abstract void draw(Graphics g, Point offset, double scale);
}
