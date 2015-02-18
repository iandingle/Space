package Test.Units;

import java.awt.image.BufferedImage;
import Engine.Destructible;
import Engine.Force;
import Physics.Point;
import Physics.Vector;
import Test.Sprites;

/**
 * A generic unit in the game.
 * @author ian
 *
 */
public class GenericUnit extends Destructible {
	private String type;
	private double maxVelocity;
	
	/**
	 * Creates a new generic unit at a given position and velocity, for a specified team, and with a specified set of attributes.
	 * @param position The initial position of the unit.
	 * @param velocity The initial velocity of the unit.
	 * @param team The team which the unit will belong to.
	 * @param attrs The attributes of the unit.
	 */
	public GenericUnit(Point position, Vector velocity, Force team, GenericUnitAttributes attrs) {
		super(position, velocity, attrs.getMass());
		
		this.setTeam(team);
		this.setRadius(attrs.getRadius());
		if (attrs.getShootingStrategy() != null) {
			this.setShootingStrategy(attrs.getShootingStrategy().clone());
			this.getShootingStrategy().setMe(this);
		}

		if (attrs.getMovingStrategy() != null) {
			this.setMovingStrategy(attrs.getMovingStrategy().clone());
			this.getMovingStrategy().setMe(this);
		}
		
		this.setMaxHitPoints(attrs.getMaxHitPoints());
		this.setHitPoints(attrs.getMaxHitPoints());
		this.type = attrs.getType();
		this.maxVelocity = attrs.getMaxVelocity();
	}

	/**
	 * When the generic unit is updated, if the magnitude of its velocity is greater than a set maximum, the magnitude is set to that maximum.
	 */
	public void updatePosition() {
		if (this.getVelocity().getMagnitude() > this.maxVelocity) {
			//this.getVelocity().setMagnitude(this.maxVelocity);
			this.setVelocity(new Vector(this.maxVelocity, this.getVelocity().getDirection()));
		}
		
		super.updatePosition();
	}
	
	/**
	 * Gets all the sprites for this unit.
	 */
	@Override
	public BufferedImage[] getImages() {
		return Sprites.getSprites(type);
	}	
}
