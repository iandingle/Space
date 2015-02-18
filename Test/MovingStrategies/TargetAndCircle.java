package Test.MovingStrategies;

import java.util.ArrayList;

import Engine.Destructible;
import Engine.Movement;
import Engine.Unit;
import Physics.Vector;

public class TargetAndCircle implements Movement {
	private Unit me;
    private Destructible target;
    private double circleRadius;
    private double approachAngle;
    private double circleForce;
    private boolean isClockwise;

    public TargetAndCircle(double radius, double force, double approach, boolean direction)
    {
        this.circleForce = force;
        this.circleRadius = radius;     
        this.approachAngle = approach;
        this.isClockwise = direction;
        this.target = null;
    }
  
    public boolean needsList()
    {
        return (target == null);
    }

    public void updateMovement()
    {
        double angle = me.getPosition().angleTo(target.getPosition());

        if (me.getPosition().distanceTo(target.getPosition()) - target.getRadius() < this.circleRadius)
        {
            double dif = isClockwise ? 90 : -90;

            me.exertForce(new Vector(circleForce, angle + dif));
        }         
        else
        {
            me.exertForce(new Vector(circleForce, angle + approachAngle));
        }            
    }

    public void updateMovement(ArrayList<Destructible> targets)
    {
        double distance = 999999;
        for (Destructible potentialTarget : targets)
        {                
            if (potentialTarget.getTeam() != me.getTeam())
            {
                if (me.getPosition().distanceTo(potentialTarget.getPosition()) - potentialTarget.getRadius() < distance)
                {
                    distance = me.getPosition().distanceTo(potentialTarget.getPosition()) - potentialTarget.getRadius();
                    target = potentialTarget;
                }
            }
        }            
    }

    public void removeTarget(Destructible target)
    {
        if (target == this.target)
        {
            this.target = null;
        }
    }
    
    public Movement clone() {
    	return new TargetAndCircle(this.circleRadius, this.circleForce, this.approachAngle, this.isClockwise);
    }
    
    public void setMe(Destructible me) {
    	this.me = me;
    }
    
}
