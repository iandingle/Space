package Engine.Manipulators;

import java.util.ArrayList;

import Engine.Destructible;
import Engine.Manipulator;
import Engine.Shooter;

/**
 * Watches units in the simulation that are capable of shooting to determine if they
 * are capable of shooting at any targets and performing the shots.
 * @author ian
 *
 */
public class Targeter implements Manipulator{

	/**
	 * The units that are capable of shooting.
	 */
	private ArrayList<Shooter> shooters;
	/**
	 * The destructible objects that can be shot at.
	 */
	private ArrayList<Destructible> targets;
	
	/**
	 * creates a new instance of a Targeter.
	 */
	public Targeter() {
		shooters = new ArrayList<Shooter>();
		targets = new ArrayList<Destructible>();
	}
	
	/**
	 * Registers a new shooter in the targeter.
	 * @param s
	 */
	public void registerShooter(Shooter s) {
		shooters.add(s);
	}
	
	/**
	 * Removes a shooter from the targeter.
	 * @param s
	 */
	public void deregisterShooter(Shooter s) {
		shooters.remove(s);
	}
	
	public void registerTarget(Destructible d) {
		targets.add(d);
	}
	
	public void deregisterTarget(Destructible d) {
		targets.remove(d);
	}
	
	@Override
	public void go() {
		// TODO Auto-generated method stub
		
		for (Shooter shoot : shooters) {
			for (Destructible target : targets) {
				if (shoot.canFire(target)) {
					shoot.fire(target.getPosition());
				}	
			}
		}
	}
}
