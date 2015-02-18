package Test.ShootingStrategies;

import Physics.Point;
import Physics.Vector;
import Test.Projectiles.ProjectileFactory;
import Engine.Destructible;
import Engine.Shooter;

public class CircularShootingStrategy implements Shooter {
	private Destructible me;
	private long lastShot;
	private double magnitude;
	private long delay;
	
	private double maxRange;
	private double minRange;
	
	private ProjectileFactory factory;
	
	public CircularShootingStrategy(double mag, long delay, double minRange, double maxRange, ProjectileFactory factory) {
		this.lastShot = System.currentTimeMillis();
		this.magnitude = mag;
		this.delay = delay;
		this.maxRange = maxRange;
		this.minRange = minRange;
		this.factory = factory;
	}
	
	public boolean canFire(Destructible who) {
		if (who == this.me) {
			return false;
		}
		
		if (who.getTeam() == this.me.getTeam()) {
			return false;
		}
		
		long time = System.currentTimeMillis();
		
		if (Math.abs(time - lastShot) < delay) {
			return false;
		}
		
		double dist = me.getPosition().distanceTo(who.getPosition()); 
		if (dist > maxRange || dist < minRange) {
			return false;
		}
		
		lastShot = time;
		
		return true;
	}
	
	@Override
	public void fire(Point where) {
		try {
			//new TestProjectile(this.me.getPosition(), new Vector(2, this.me.getPosition().angleTo(where)), this.me).register();
			factory.createProjectile(this.me.getPosition(), new Vector(this.magnitude, this.me.getPosition().angleTo(where)), this.me).register();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setMe(Destructible me) {
		this.me = me;
	}
	
	public Shooter clone() {
		return new CircularShootingStrategy(this.magnitude, this.delay, this.minRange, this.maxRange, this.factory);
	}
}
