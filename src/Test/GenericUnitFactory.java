package Test;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import Engine.Force;
import Physics.Point;
import Physics.Vector;

public class GenericUnitFactory {
	private static HashMap<String, GenericUnitAttributes> stats = new HashMap<String, GenericUnitAttributes>();
	
	public static boolean CreateUnitType(String key, GenericUnitAttributes attrs, BufferedImage[] images) {
		if (!stats.containsKey(key)) {
			Sprites.addSprites(key, images);
			stats.put(key, attrs);
			
			return true;
		}
		
		return false;
	}
	
	public static GenericUnit CreateUnit(String type, Point position, Vector velocity, Force team) {
		return new GenericUnit(position, velocity, team, stats.get(type));
	}
}
