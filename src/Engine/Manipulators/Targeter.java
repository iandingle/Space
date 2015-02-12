package Engine.Manipulators;

import java.util.ArrayList;

import Engine.Destructible;
import Engine.Manipulator;
import Engine.Shooter;

public class Targeter implements Manipulator{

	private ArrayList<Shooter> shooters;
	private ArrayList<Destructible> targets;
	
	public Targeter() {
		shooters = new ArrayList<Shooter>();
		targets = new ArrayList<Destructible>();
	}
	
	public void registerShooter(Shooter s) {
		shooters.add(s);
	}
	
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
