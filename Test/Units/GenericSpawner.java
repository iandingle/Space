/**
 * 
 */
package Test.Units;

import Engine.Force;
import Engine.GameWindow;
import Physics.Point;
import Physics.Vector;

/**
 * A generic unit that is capable of spawning other units.
 * @author ian
 *
 */
public class GenericSpawner extends GenericUnit {
	private Spawner spawn;
	
	/**
	 * Creates a new spawner at an initial position and velocity, with a given set of attributes and for a specified team.
	 * @param position The initial position of the spawner.
	 * @param velocity The initial velocity of the spawner.
	 * @param team The team which the spawner will belong to.
	 * @param attrs The attributes for the spawner.
	 */
	public GenericSpawner(Point position, Vector velocity, Force team, GenericSpawnerAttributes attrs) {
		super(position, velocity, team, attrs);
		
		spawn = new Spawner();
		spawn.setPosition(position);
		spawn.setFactory(attrs.getFactory());
		spawn.setRate(attrs.getRate());
		spawn.setTeam(team);
		spawn.setType(attrs.getSpawnType());
	}
	
	/**
	 * Registers this spawner in the game.
	 */
	public void register() {
		super.register();
		GameWindow.getInstance().registerManipulator(spawn);
	}
	
	/**
	 * Removes this spawner from the game.
	 */
	public void deregister() {
		super.deregister();
		GameWindow.getInstance().deregisterManipulator(spawn);
	}
	
	/**
	 * Sets the type of unit that will be spawned by this spawner. Use this only if the unit is of the same class as the current factory. Otherwise, use the changeFactory method to ensure the correct factory is used to create the unit.
	 * @param spawnType The unit type to set.
	 */
	public void setSpawnType(String spawnType) {
		spawn.setType(spawnType);
	}
	
	/**
	 * Sets the rate at which this spawner will spawn units.
	 * @param rate The rate to set.
	 */
	public void setSpawnRate(int rate) {
		spawn.setRate(rate);
	}
	
	/**
	 * Will set the underlying spawner's factory to a new factory.
	 * @param factory
	 */
	public void changeFactory(GenericUnitFactory factory) {
		spawn.setFactory(factory);
	}
}
