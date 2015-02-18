package Engine.Manipulators;

import java.util.ArrayList;

import Engine.Destructible;
import Engine.Manipulator;
import Engine.Projectile;

/**
 * Watches projectiles in the simulation to determine and perform hits on destrectible objects
 * and to enforce their lifespan.
 * @author ian
 *
 */
public class ProjectileWatcher implements Manipulator{

	/**
	 * The projectiles being watched.
	 */
	private ArrayList<Projectile> projectiles;
	
	/**
	 * The destructible objects the projectiles could hit.
	 */
	private ArrayList<Destructible> targets;
	
	/**
	 * Creates a new instance of the projectile watcher.
	 */
	public ProjectileWatcher() {
		projectiles = new ArrayList<Projectile>();
		targets = new ArrayList<Destructible>();
	}
	
	/**
	 * Registers a projectile with this projectile watcher.
	 * @param p The projectile to register.
	 */
	public void registerProjectile(Projectile p) {
		this.projectiles.add(p);
	}
	
	/**
	 * Removes a projectile from this projectile watcher.
	 * @param p The projectile to deregister.
	 */
	public void deregisterProjectile(Projectile p) {
		this.projectiles.remove(p);
	}
	
	/**
	 * Registers a destructible object as a target in the projectile watcher.
	 * @param d
	 */
	public void registerTarget(Destructible d) {
		this.targets.add(d);
	}
	
	/**
	 * Removes a destructible object as a target in the projectile watcher.
	 * @param d
	 */
	public void deregisterTarget(Destructible d) {
		this.targets.remove(d);
	}
	
	/**
	 * Determines if any projectiles have hit a target, performs the hits on the targets, 
	 * and removes any projectiles that are past their lifetime.
	 */
	public void go() {
		 //List<Projectile> newP = new List<Projectile>(projectiles);
         //List<Destructible> newT = new List<Destructible>(targets);

         for (int i = 0; i < projectiles.size(); i++)
         {
             Projectile pro = projectiles.get(i);
             for (int j = 0; j < targets.size(); j++)
             {
                 Destructible dest = targets.get(j);

                 if (pro.isHit(dest))
                 {
                     pro.hit(dest);
                     break;
                 }
             }

             if (pro.checkLifeTime())
             {
                 pro.deregister();
             }
         }
	}
}
