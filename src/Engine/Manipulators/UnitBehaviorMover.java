package Engine.Manipulators;

import java.util.ArrayList;

import Engine.Destructible;
import Engine.Manipulator;
import Engine.Movement;

public class UnitBehaviorMover implements Manipulator{

	private ArrayList<Movement> movers;
	private ArrayList<Destructible> targets;
	
	public UnitBehaviorMover() {
		movers = new ArrayList<Movement>();
		targets = new ArrayList<Destructible>();
	}	

	public void registerMover(Movement m) {
		movers.add(m);
	}
	
	public void deregisterMover(Movement m) {
		movers.remove(m);
	}
	
	public void registerTarget(Destructible d) {
		targets.add(d);
	}
	
	public void deregisterTarget(Destructible d) {
		targets.remove(d);
		
		for (Movement m : movers) {
			m.removeTarget(d);
		}
	}
	
	@Override
	public void go() {
		for (Movement m : movers) {
			if (m.needsList()) {
				m.updateMovement(targets);
			}
			else {
				m.updateMovement();
			}
		}
	}
}
