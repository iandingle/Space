package Test.Projectiles;

import Engine.Destructible;
import Engine.Projectile;
import Physics.Point;
import Physics.Vector;

public class LazerBeamFactory extends ProjectileFactory{
	public LazerBeamFactory(String type) {
		super(type);
	}
	
	public Projectile createProjectile(Point position, Vector velocity, Destructible source) {
		return new LazerBeam(position, velocity, source, (LazerBeamAttributes) ProjectileFactory.stats.get(getType()));
	}
}
