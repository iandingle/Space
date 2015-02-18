package Engine;

import Physics.Point;
import Physics.Vector;

public abstract class Projectile extends Unit{

	public Projectile(Point position, Vector velocity, double mass) {
		super(position, velocity, mass);
		// TODO Auto-generated constructor stub
	}
	
	private int damage;
	private int range;
	
	private Unit source;
	private Point start;
	
	public void hit(Destructible target) {
		target.inflictDamage(damage);
		deregister();		
	}
	
	public boolean isHit(Destructible target) {
		if (target.getTeam() == source.getTeam()) {
		    return false;
	    }
	
	    if (getPosition().distanceTo(target.getPosition()) < (getRadius() + target.getRadius())) {
		    return true;
	    }
	
	    return false;
	}
	
	public boolean checkLifeTime() {
		double dist = start.distanceTo(getPosition()); 
		if (dist > range) {
		    return true;
	    }
	
	    return false;
	}
	
	public void register() {
		super.register();
		
		GameWindow.getInstance().registerProjectile(this);
	}
	
	public void deregister() {
		super.deregister();
		
		GameWindow.getInstance().deregisterProjectile(this);
	}
	
	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 * @return the range
	 */
	public int getRange() {
		return range;
	}

	/**
	 * @param range the range to set
	 */
	public void setRange(int range) {
		this.range = range;
	}
	
	/**
	 * @return the source
	 */
	public Unit getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	protected void setSource(Unit source) {
		this.source = source;
	}

	/**
	 * @return the start
	 */
	public Point getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	protected void setStart(Point start) {
		this.start = start;
	}
}
