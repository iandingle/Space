package Engine.Manipulators;

import java.util.ArrayList;

import Engine.Destructible;
import Engine.Manipulator;
import Engine.Projectile;

public class ProjectileWatcher implements Manipulator{

	private ArrayList<Projectile> projectiles;
	private ArrayList<Destructible> targets;
	
	public ProjectileWatcher() {
		projectiles = new ArrayList<Projectile>();
		targets = new ArrayList<Destructible>();
	}
	
	public void registerProjectile(Projectile p) {
		this.projectiles.add(p);
	}
	
	public void deregisterProjectile(Projectile p) {
		this.projectiles.remove(p);
	}
	
	public void registerTarget(Destructible d) {
		this.targets.add(d);
	}
	
	public void deregisterTarget(Destructible d) {
		this.targets.remove(d);
	}
	
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
