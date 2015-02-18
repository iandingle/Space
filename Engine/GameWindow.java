package Engine;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import Engine.Manipulators.FreeObjectMover;
import Engine.Manipulators.ProjectileWatcher;
import Engine.Manipulators.Targeter;
import Engine.Manipulators.UnitBehaviorMover;
import Physics.FreeObject;
import Physics.Point;

public class GameWindow extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int WIDTH = 1000;
	public static int HEIGHT = 600;
	
	public static double scale;
	public static Point offset;
	
	private static GameWindow instance;
	public static GameWindow getInstance() {
		return instance;
	}
	
	private ArrayList<Manipulator> manipulators;
	private FreeObjectMover mover;
	private Targeter targeter;
	private UnitBehaviorMover behavior;
	private ProjectileWatcher watcher;
	
	public GameWindow()
	{
		instance = this;
		
		this.setSize(WIDTH, HEIGHT);
		this.setBackground(Color.BLACK);
		
		scale = 1;
		offset = new Point(0, 0);
		
		manipulators = new ArrayList<Manipulator>();
		mover = new FreeObjectMover();
		targeter = new Targeter();
		behavior = new UnitBehaviorMover();
		watcher = new ProjectileWatcher();
		
		registerManipulator(mover);
		registerManipulator(targeter);
		registerManipulator(behavior);
		registerManipulator(watcher);
				
		Timer timer = new Timer();		
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {									
				for (int i = 0; i < manipulators.size(); i++) {
			    	manipulators.get(i).go();
			    }
											    							   			
				repaint();
			}
		}, 50, 25);			
	}	
	
	public void UpdateEngine() {
		for (int i = 0; i < manipulators.size(); i++) {
			manipulators.get(i).go();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
      
		ArrayList<FreeObject> cheese = new ArrayList<FreeObject>(mover.getFreeObjects());
		
      	for (FreeObject toDraw : cheese) {
    	  	toDraw.draw(g, offset, scale);
      	}
	}
	
	public void shiftX(double amount) {
		offset.add(new Point(amount, 0));
	}
	
	public void shiftY(double amount) {
		offset.add(new Point(0, amount));
	}
	
	public void zoomIn(double amount) {
		scale += amount;
	}
	
	public void zoomOut(double amount) {
		scale -= amount;
		
		if (scale <= 0.001)
        {
            scale = 0.075;
        }
	}
	
	public void registerManipulator(Manipulator man) {
		manipulators.add(man);
	}
	
	public void deregisterManipulator(Manipulator man) {
		manipulators.remove(man);
	}
	
	public void registerFreeObject(FreeObject fo) {
		mover.registerObject(fo);
	}
	
	public void deregisterFreeObject(FreeObject fo) {
		mover.deregisterObject(fo);
	}
	
	public void registerShooter(Shooter s) {
		targeter.registerShooter(s);
	}
	
	public void deregisterShooter(Shooter s) {
		targeter.deregisterShooter(s);
	}
	
	public void registerMovement(Movement move) {
		behavior.registerMover(move);
	}
	
	public void deregisterMovement(Movement move) {
		behavior.deregisterMover(move);
	}
	
	public void registerDestructible(Destructible d) {
		targeter.registerTarget(d);
		behavior.registerTarget(d);
		watcher.registerTarget(d);
	}
	
	public void deregisterDestructible(Destructible d) {
		targeter.deregisterTarget(d);
		behavior.deregisterTarget(d);
		watcher.deregisterTarget(d);
	}
	
	public void registerProjectile(Projectile p) {
		watcher.registerProjectile(p);
	}
	
	public void deregisterProjectile(Projectile p) {
		watcher.deregisterProjectile(p);
	}
}
