package Test.Units;

import Engine.Movement;
import Engine.Shooter;

/**
 * Contains all attributes required for a generic unit.
 * @author ian
 *
 */
public class GenericUnitAttributes {
	private int radius;
	private Shooter shootingStrategy;
	private Movement movingStrategy;
	private int maxHitPoints;
	private double mass;
	private String type;
	private double maxVelocity;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public Shooter getShootingStrategy() {
		return shootingStrategy;
	}
	public void setShootingStrategy(Shooter shootingStrategy) {
		this.shootingStrategy = shootingStrategy;
	}
	public Movement getMovingStrategy() {
		return movingStrategy;
	}
	public void setMovingStrategy(Movement movingStrategy) {
		this.movingStrategy = movingStrategy;
	}
	public int getMaxHitPoints() {
		return maxHitPoints;
	}
	public void setMaxHitPoints(int maxHitPoints) {
		this.maxHitPoints = maxHitPoints;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	public double getMaxVelocity() {
		return maxVelocity;
	}
	public void setMaxVelocity(double vel) {
		this.maxVelocity = vel;
	}
}
