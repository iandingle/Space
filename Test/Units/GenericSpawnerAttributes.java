package Test.Units;

/**
 * Contains all attributes needed for a generic unit capable of spawning other units.
 * @author ian
 *
 */
public class GenericSpawnerAttributes extends GenericUnitAttributes{
	private GenericUnitFactory factory;
	private String spawnType;
	private int rate;

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
	public String getSpawnType() {
		return spawnType;
	}

	/**
	 * @param type the type to set
	 */
	public void setSpawnType(String spawnType) {
		this.spawnType = spawnType;
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
}
