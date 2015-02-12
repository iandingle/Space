package Engine;

import java.util.ArrayList;

/**
 * Defines methods that must be implemented for anything with movement behaviors.
 * @author Ian
 *
 */
public interface Movement {
    boolean needsList();
    void updateMovement();
    void updateMovement(ArrayList<Destructible> targets);
    void removeTarget(Destructible target);
    Movement clone();
    void setMe(Destructible me);
}
