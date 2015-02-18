package Test.Units;

import Engine.Force;
import Engine.Manipulator;
import Physics.Point;
import Physics.Vector;

/**
 * A non-physical object in the game that creates new unit and registers them in the game.
 * @author ian
 *
 */
public class Spawner implements Manipulator {
	private long last;
	
	private int rate;
	private GenericUnitFactory factory;
	private String type;
	private Point position;
	private Force team;
	
	/**
	 * Creates a new spawner.
	 */
	public Spawner() {
		last = System.currentTimeMillis();
	}
	
	/**
	 * Creates and registers a new unit if the elapsed time since the previous spawn is greater than the rate.
	 */
	public void go() {
		long time = System.currentTimeMillis();
		
		if (Math.abs(time - last) < rate) {
			return;
		}
		
		factory.createUnit(new Point(position), new Vector(), team).register();
		last = time;
	}

	/**
	 * @return the rate
	 */
	public int getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(int rate) {
		this.rate = rate;
	}

	/**
	 * @return the factory
	 */
	public GenericUnitFactory getFactory() {
		return factory;
	}

	/**
	 * @param factory the factory to set
	 */
	public void setFactory(GenericUnitFactory factory) {
		this.factory = factory;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set. Will also set this spawner's factory to the same type.
	 */
	public void setType(String type) {
		this.type = type;
		this.factory.setType(type);
	}

	/**
	 * @return the position
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * @return the team
	 */
	public Force getTeam() {
		return team;
	}

	/**
	 * @param team the team to set
	 */
	public void setTeam(Force team) {
		this.team = team;
	}
}
