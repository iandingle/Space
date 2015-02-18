package Test.Projectiles;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import Engine.Destructible;
import Engine.Projectile;
import Physics.Point;
import Physics.Vector;
import Test.Sprites;

public class ProjectileFactory {
	protected static HashMap<String, ProjectileAttributes> stats = new HashMap<String, ProjectileAttributes>();
	
	public static boolean CreateProjectileType(String key, ProjectileAttributes attrs, BufferedImage[] images) {
		if (!stats.containsKey(key)) {
			Sprites.addSprites(key, images);
			stats.put(key, attrs);
			
			return true;
		}
		
		return false;
	}
	
	public static Projectile createProjectile(String type, Point position, Vector velocity, Destructible source) {
		return new GenericProjectile(position, velocity, source, stats.get(type));
	}
	
	private String type;
	
	public ProjectileFactory(String type) {
		this.type = type;
	}
	
	public ProjectileFactory clone() {
		return new ProjectileFactory(this.type);
	}
	
	public Projectile createProjectile(Point position, Vector velocity, Destructible source) {
		return new GenericProjectile(position, velocity, source, stats.get(this.type));
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
