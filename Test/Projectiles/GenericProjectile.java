package Test.Projectiles;


import java.awt.image.BufferedImage;
import Engine.Projectile;
import Engine.Unit;
import Physics.Point;
import Physics.Vector;
import Test.Sprites;

public class GenericProjectile extends Projectile{
	private String type;
	
	public GenericProjectile(Point position, Vector velocity, Unit shooter, ProjectileAttributes attrs) {
		super(position, velocity, attrs.getMass());
		
		this.setRadius(attrs.getRadius());
		this.setDamage(attrs.getDamage());
		this.setRange(attrs.getRange());
		this.setSource(shooter);
		this.setStart(new Point(position));
		this.type = attrs.getType();
	}

	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return Sprites.getSprites(type)[0];
	}

}
