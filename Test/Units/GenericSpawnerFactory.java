package Test.Units;

import Engine.Force;
import Physics.Point;
import Physics.Vector;

/**
 * Creates new units that are capable of spawning.
 * @author ian
 *
 */
public class GenericSpawnerFactory extends GenericUnitFactory {
	/**
	 * Creates a new unit of a specified type with a given initial position and velocity and for a specified team.
	 * @param type The type of unit to create.
	 * @param position The initial position of the unit.
	 * @param velocity The initial velocity of the unit.
	 * @param team The team the unit will belong to.
	 * @return the new unit. Returns null if the specified type is not registered.
	 */
	public static GenericUnit createUnit(String type, Point position, Vector velocity, Force team) {
		if (stats.containsKey(type)) {
			return new GenericSpawner(position, velocity, team, (GenericSpawnerAttributes) stats.get(type));
		}
		
		return null;
	}
	
	/**
	 * Creates a new instance of a spawner factory.
	 * @param type
	 */
	public GenericSpawnerFactory(String type) {
		super(type);
	}
	
	/**
	 * Creates a new spawner of the type that this factory is configured to produce.
	 */
	public GenericUnit createUnit(Point position, Vector velocity, Force team) {
		return new GenericSpawner(position, velocity, team,(GenericSpawnerAttributes) stats.get(getType()));
	}

}
