package Engine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Physics.Point;
import Physics.Vector;

public abstract class Destructible extends Unit {

	public Destructible(Point position, Vector velocity, double mass) {
		super(position, velocity, mass);
		// TODO Auto-generated constructor stub
	}
	
	private int hitPoints;
	private int maxHitPoints;
	
	public void inflictDamage(int damage) {
		hitPoints -= damage;
		
		if (hitPoints <= 0) {
			deregister();
		}
	}
	
	public void register() {
		super.register();
		
		GameWindow.getInstance().registerDestructible(this);
	}
	
	public void deregister() {
		super.deregister();
		
		GameWindow.getInstance().deregisterDestructible(this);
	}
	
	public abstract BufferedImage[] getImages();
	
	public BufferedImage getImage() {
		BufferedImage[] images = getImages();

        int index = (hitPoints / (maxHitPoints / images.length));
        if (index >= 0) {
        	index = index < images.length ? index : images.length - 1;
        }
        else {
        	index = 0;
        }
        
        return images[index];
	}	
	
	
	public void draw(Graphics g, Point offset, double scale) {
		double width;
		
		super.draw(g, offset, scale);
		
		g.setColor(ForceColours.GetForceColour(getTeam()));
		width = (int)(getRadius() * 2 * GameWindow.scale);
		width = width * ((double)hitPoints / (double)maxHitPoints);
		
		Point pos = Point.subtract(getPosition(), GameWindow.offset);
		
		g.fillRect((int)((pos.getX() - getRadius()) * GameWindow.scale), (int)((pos.getY() - getRadius()) * GameWindow.scale), (int)(width), (int)(7 * GameWindow.scale));
	}
	
	/**
	 * @return the hitPoints
	 */
	public int getHitPoints() {
		return hitPoints;
	}

	/**
	 * @param hitPoints the hitPoints to set
	 */
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	/**
	 * @return the maxHitPoints
	 */
	public int getMaxHitPoints() {
		return maxHitPoints;
	}
	
	/**
	 * @param maxHitPoints the maxHitPoints to set
	 */
	public void setMaxHitPoints(int maxHitPoints) {
		this.maxHitPoints = maxHitPoints;
	}
}
