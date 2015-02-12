package Engine;

import java.awt.Color;

public class ForceColours {
	public static Color GetForceColour(Force f) {
		switch (f) {
		case RED:
			return Color.RED;			
		case GREEN:
			return Color.GREEN;			
		case BLUE:
			return Color.BLUE;			
		}
		
		return Color.GRAY;
	}
}
