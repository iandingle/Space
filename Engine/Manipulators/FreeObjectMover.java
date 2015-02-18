package Engine.Manipulators;

import java.util.ArrayList;

import Engine.Manipulator;
import Physics.FreeObject;

/**
 * Iterates through all registered Free Objects and updates their position.
 * @author Ian
 *
 */
public class FreeObjectMover implements Manipulator {
	
	/**
	 * The objects registered to be moved by the FreeObjectMover.
	 */
	private ArrayList<FreeObject> objects;
	
	/**
	 * Creates a new instance of a free object mover.
	 */
	public FreeObjectMover() {
		objects = new ArrayList<FreeObject>();
	}
	
	/**
	 * Registers a free object to be updated.
	 * @param fo The free object to register.
	 */
	public void registerObject(FreeObject fo) {
		objects.add(fo);
	}
	
	/**
	 * Removes a free object to stop it from being updated.
	 * @param fo The free object to remove.
	 */
	public void deregisterObject(FreeObject fo) {
		objects.remove(fo);
	}
		
	/**
	 * Updates the position of all registered free objects.
	 */
	public void go() {
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).updatePosition();
		}
	}
	
	/**
	 * Gets a list of all registered free objects.
	 * @return
	 */
	public ArrayList<FreeObject> getFreeObjects() {
		return objects;
	}
}
