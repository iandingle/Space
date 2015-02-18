package Test.Projectiles;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Engine.Unit;
import Physics.Angle;
import Physics.Point;
import Physics.Vector;

public class LazerBeam extends GenericProjectile{
	private int length;
	private Color colour;
	
	public LazerBeam(Point position, Vector velocity, Unit shooter, LazerBeamAttributes attrs) {
		super(position, velocity, shooter, attrs);
		
		this.length = attrs.getRadius();
		this.colour = attrs.getColour();
	}

	public void draw(Graphics g, Point offset, double scale) {
		Point pos = Point.subtract(getPosition(), offset);
		double dir = Angle.toRadians(getVelocity().getDirection());
		
		g.setColor(colour);
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke((float)(3 * scale)));
		g2.drawLine((int)(pos.getX() * scale), (int)(pos.getY() * scale), (int)((pos.getX() + (length * Math.cos(dir))) * scale), (int)((pos.getY() + (length * Math.sin(dir) )) * scale));
	}
}
