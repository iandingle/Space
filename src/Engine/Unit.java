package Engine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Physics.FreeObject;
import Physics.Point;
import Physics.Vector;

/**
 * Represents a unit in the game, with possible strategies for shooting and moving.
 * @author Ian
 *
 */
public abstract class Unit extends FreeObject{

	private int radius;
	private Force team;
	private Shooter shootingStrategy;
	private Movement movingStrategy;
		
	public Unit(Point position, Vector velocity, double mass) {
		super(position, velocity, mass);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Puts this unit into the game engine.
	 */
	public void register() {
		GameWindow window = GameWindow.getInstance();
		window.registerFreeObject(this);
		
		if (shootingStrategy != null) {
			window.registerShooter(this.shootingStrategy);
		}
		
		if (movingStrategy != null) {
			window.registerMovement(this.movingStrategy);
		}
	}
	
	/**
	 * Removes this unit from the game engine.
	 */
	public void deregister() {
		GameWindow window = GameWindow.getInstance();
		window.deregisterFreeObject(this);
		
		if (shootingStrategy != null) {
			window.deregisterShooter(this.shootingStrategy);
		}
		
		if (movingStrategy != null) {
			window.deregisterMovement(this.movingStrategy);
		}
	}
	
	/**
	 * Gets the image used to draw this unit.
	 * @return A BufferedImage to be used in drawing this unit.
	 */
	public abstract BufferedImage getImage();
	
	/**
	 * Draws the unit onto the specified graphics.
	 */
	@Override
	public void draw(Graphics g, Point offset, double scale) {	
		Point pos = Point.subtract(getPosition(), offset);
		
		g.drawImage(getImage(), (int)((pos.getX() - radius) * scale), (int)((pos.getY() - radius) * scale), (int)(radius * 2 * scale), (int)(radius * 2 * scale), null);
	}
	
	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/**
	 * @return the team
	 */
	public Force getTeam() {
		return team;
	}

	/**
	 * @param team the team to set
	 */
	public void setTeam(Force team) {
		this.team = team;
	}

	/**
	 * @return the shootingStrategy
	 */
	public Shooter getShootingStrategy() {
		return shootingStrategy;
	}

	/**
	 * @param shootingStrategy the shootingStrategy to set
	 */
	public void setShootingStrategy(Shooter shootingStrategy) {
		this.shootingStrategy = shootingStrategy;
	}

	/**
	 * @return the movingStrategy
	 */
	public Movement getMovingStrategy() {
		return movingStrategy;
	}

	/**
	 * @param movingStrategy the movingStrategy to set
	 */
	public void setMovingStrategy(Movement movingStrategy) {
		this.movingStrategy = movingStrategy;
	}
}
