package Test;

import java.awt.image.BufferedImage;
import Engine.Destructible;
import Engine.Force;
import Physics.Point;
import Physics.Vector;

public class GenericUnit extends Destructible {
	private String type;
	private double maxVelocity;
	
	public GenericUnit(Point position, Vector velocity, Force team, GenericUnitAttributes attrs) {
		super(position, velocity, attrs.getMass());
		
		this.setTeam(team);
		this.setRadius(attrs.getRadius());
		this.setShootingStrategy(attrs.getShootingStrategy().clone());
		this.setMovingStrategy(attrs.getMovingStrategy().clone());
		this.setMaxHitPoints(attrs.getMaxHitPoints());
		this.setHitPoints(attrs.getMaxHitPoints());
		this.type = attrs.getType();
		this.maxVelocity = attrs.getMaxVelocity();
		
		this.getShootingStrategy().setMe(this);
		this.getMovingStrategy().setMe(this);
	}

	public void updatePosition() {
		if (this.getVelocity().getMagnitude() > this.maxVelocity) {
			//this.getVelocity().setMagnitude(this.maxVelocity);
			this.setVelocity(new Vector(this.maxVelocity, this.getVelocity().getDirection()));
		}
		
		super.updatePosition();
	}
	
	@Override
	public BufferedImage[] getImages() {
		return Sprites.getSprites(type);
	}	
}
