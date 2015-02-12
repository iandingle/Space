package Test;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import Engine.Destructible;
import Physics.Point;
import Physics.Vector;

public class ProjectileFactory {
	private static HashMap<String, ProjectileAttributes> stats = new HashMap<String, ProjectileAttributes>();
	
	public static boolean CreateProjectileType(String key, ProjectileAttributes attrs, BufferedImage[] images) {
		if (!stats.containsKey(key)) {
			Sprites.addSprites(key, images);
			stats.put(key, attrs);
			
			return true;
		}
		
		return false;
	}
	
	public static GenericProjectile CreateProjectile(String type, Point position, Vector velocity, Destructible source) {
		return new GenericProjectile(position, velocity, source, stats.get(type));
	}
}
