package Test;

import Physics.Point;
import Physics.Vector;
import Engine.Destructible;
import Engine.Shooter;

public class CircularShootingStrategy implements Shooter {
	private Destructible me;
	private long lastShot;
	private double magnitude;
	private long delay;
	
	private String type;
	
	public CircularShootingStrategy(String type, double mag, long delay) {
		this.lastShot = System.currentTimeMillis();
		this.type = type;
		this.magnitude = mag;
		this.delay = delay;
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
		
		lastShot = time;
		
		return true;
	}
	
	@Override
	public void fire(Point where) {
		try {
			//new TestProjectile(this.me.getPosition(), new Vector(2, this.me.getPosition().angleTo(where)), this.me).register();
			ProjectileFactory.CreateProjectile(type, this.me.getPosition(), new Vector(this.magnitude, this.me.getPosition().angleTo(where)), this.me).register();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setMe(Destructible me) {
		this.me = me;
	}
	
	public Shooter clone() {
		return new CircularShootingStrategy(this.type, this.magnitude, this.delay);
	}
}
