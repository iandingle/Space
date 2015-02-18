package Engine;

import Physics.Point;

/**
 * Defines methods that must be implemented for anything that is capable of shooting.
 * @author Ian
 *
 */
public interface Shooter {
	/**
	 * Performs a firing action towards a specified point.
	 * @param where a Point that will be fired at.
	 */
	void fire(Point where);
	
	/**
	 * Determines if a specified target can be fired at.
	 * @param who A potential target.
	 * @return true if the target should be fired at; otherwise, false.
	 */
	boolean canFire(Destructible who);
	
	/**
	 * Sets the owner of this strategy.
	 * @param me
	 */
	void setMe(Destructible me);

	/**
	 * Creates an exact copy of this strategy for use for another owner.
	 * @return
	 */
	Shooter clone();
}
