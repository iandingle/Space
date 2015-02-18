package Test;

import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * Contains all sprites that will be drawn to the screen.
 * @author ian
 *
 */
public class Sprites {
	/**
	 * Contains sets of sprites associated with a given access key.
	 */
	private static HashMap<String, BufferedImage[]> sprites = new HashMap<String, BufferedImage[]>();
	
	/**
	 * Adds a new set of sprites into the set.
	 * @param key The access key for the new set.
	 * @param images The array of images representing the sprite set.
	 * @return True if the set is added, false is the key already has sprites associated with it.
	 */
	public static boolean addSprites(String key, BufferedImage[] images) {
		if (!sprites.containsKey(key)) {
			sprites.put(key, images);
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * Retrieves a set of sprites.
	 * @param key The access key for the sprites.
	 * @return The array  of images representing the sprites.
	 */
	public static BufferedImage[] getSprites(String key) {
		return sprites.get(key);
	}
}
