package Test;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Sprites {
	private static HashMap<String, BufferedImage[]> sprites = new HashMap<String, BufferedImage[]>();
	
	public static boolean addSprites(String key, BufferedImage[] images) {
		if (!sprites.containsKey(key)) {
			sprites.put(key, images);
			
			return true;
		}
		
		return false;
	}
	
	public static BufferedImage[] getSprites(String key) {
		return sprites.get(key);
	}
}
