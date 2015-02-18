package Test.Units;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import Engine.Force;
import Physics.Point;
import Physics.Vector;
import Test.Sprites;

/**
 * A factory capable of creating generic units.
 * @author ian
 *
 */
public class GenericUnitFactory {
	/**
	 * A table of attributes for all registered unit types.
	 */
	protected static HashMap<String, GenericUnitAttributes> stats = new HashMap<String, GenericUnitAttributes>();
	
	/**
	 * Registers a new unit type. 
	 * @param key The name of the new unit type
	 * @param attrs the attributes that the new unit type will use.
	 * @param images the sprites to use for this unit type.
	 * @return true if the unit was added, false if the unit already was registered.
	 */
	public static boolean CreateUnitType(String key, GenericUnitAttributes attrs, BufferedImage[] images) {
		if (!stats.containsKey(key)) {
			Sprites.addSprites(key, images);
			stats.put(key, attrs);
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * Creates a unit of the specified type.
	 * @param type The type of unit to create.
	 * @param position The initial position of the unit to create.
	 * @param velocity The initial velocity of the unit to create.
	 * @param team The team which the unit will belong to.
	 * @return A new unit of the specified type. If the type is not registered, returns null.
	 */
	public static GenericUnit createUnit(String type, Point position, Vector velocity, Force team) {
		if (stats.containsKey(type)) {
			return new GenericUnit(position, velocity, team, stats.get(type));
		}
		
		return null;
	}
	
	/**
	 * The type of unit this factory will create.
	 */
	private String type;
	
	/**
	 * Creates a new instance of a Generic Unit Factory configured to produce units of the specified type.
	 * @param type The type of unit to produce.
	 */
	public GenericUnitFactory(String type) {
		this.type = type;
	}
	
	/**
	 * Creates a unit of the type this factory has been configured to produce.
	 * @param position The initial position of the unit to create.
	 * @param velocity The initial velocity of the unit to create.
	 * @param team The team which the new unit will belong to.
	 * @return A new unit of the type this factory is configured to produce. returns null if the type is not registered.
	 */
	public GenericUnit createUnit(Point position, Vector velocity, Force team) {
		if (stats.containsKey(type)) {
			return new GenericUnit(position, velocity, team, stats.get(type));
		}
		
		return null;
	}

	/**
	 * @return the unit type this factory produces.
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the unit type this factory produces.
	 */
	public void setType(String type) {
		this.type = type;
	}
}
