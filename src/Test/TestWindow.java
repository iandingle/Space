package Test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Engine.Force;
import Engine.GameWindow;
import Physics.Point;
import Physics.Vector;

public class TestWindow extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameWindow game;
	
	public static void main(String[] args) {
		TestWindow cheese = new TestWindow();
		cheese.game = new GameWindow();
		
		cheese.setSize(GameWindow.WIDTH, GameWindow.HEIGHT);
		cheese.setLayout(new BorderLayout());
		cheese.add(cheese.game, BorderLayout.CENTER);
		cheese.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cheese.setVisible(true);
		
		cheese.label = new JLabel("HOWDY");
		cheese.add(cheese.label, BorderLayout.SOUTH);
		
		JPanel shite = new JPanel();
		
		JButton poop = new JButton("Zoom In");		
		poop.addActionListener(cheese);
		
		JButton poop2 = new JButton("Zoom Out");
		poop2.addActionListener(cheese);
		
		JButton poop3 = new JButton("Up");
		poop3.addActionListener(cheese);
		
		JButton poop4 = new JButton("Down");
		poop4.addActionListener(cheese);
		
		JButton poop5 = new JButton("Left");
		poop5.addActionListener(cheese);
		
		JButton poop6 = new JButton("Right");
		poop6.addActionListener(cheese);
		
		shite.add(poop);
		shite.add(poop2);
		
		JPanel shite2 = new JPanel(new BorderLayout());
		
		shite2.add(poop3, BorderLayout.NORTH);
		shite2.add(poop4, BorderLayout.SOUTH);
		shite2.add(poop5, BorderLayout.WEST);
		shite2.add(poop6, BorderLayout.EAST);
		
		shite.add(shite2);
		
		cheese.add(shite, BorderLayout.SOUTH);
		
		
		BufferedImage[] sprites = new BufferedImage[5];
		
		try {
			sprites[0] = ImageIO.read(new File("Images/ColumnGhost4.png"));
			sprites[1] = ImageIO.read(new File("Images/ColumnGhost3.png"));
			sprites[2] = ImageIO.read(new File("Images/ColumnGhost2.png"));
			sprites[3] = ImageIO.read(new File("Images/ColumnGhost1.png"));
			sprites[4] = ImageIO.read(new File("Images/ColumnGhost.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		GenericUnitAttributes testAttrs = new GenericUnitAttributes();
		
		testAttrs.setMass(5);
		testAttrs.setMaxHitPoints(55);
		testAttrs.setRadius(20);
		testAttrs.setType("test");
		testAttrs.setShootingStrategy(new CircularShootingStrategy("pellet", 2, 500));
		testAttrs.setMaxVelocity(3);
		
		testAttrs.setMovingStrategy(new TargetAndCircle(50, 1, 5, true));
		
		GenericUnitFactory.CreateUnitType("test", testAttrs, sprites);
		
		sprites = new BufferedImage[5];
		
		try {
			sprites[0] = ImageIO.read(new File("Images/Beholder4.png"));
			sprites[1] = ImageIO.read(new File("Images/Beholder3.png"));
			sprites[2] = ImageIO.read(new File("Images/Beholder2.png"));
			sprites[3] = ImageIO.read(new File("Images/Beholder1.png"));
			sprites[4] = ImageIO.read(new File("Images/Beholder.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		testAttrs = new GenericUnitAttributes();
		
		testAttrs.setMass(50);
		testAttrs.setMaxHitPoints(200);
		testAttrs.setRadius(35);
		testAttrs.setType("Beholder");
		testAttrs.setShootingStrategy(new CircularShootingStrategy("magicMissile", 10, 1500));
		testAttrs.setMaxVelocity(2);
		testAttrs.setMovingStrategy(new TargetAndCircle(150, 30, 3, false));
		
		GenericUnitFactory.CreateUnitType("Beholder", testAttrs, sprites);
		
		ProjectileAttributes testProjectileAttrs = new ProjectileAttributes();
		
		testProjectileAttrs.setDamage(5);
		testProjectileAttrs.setMass(1);
		testProjectileAttrs.setRadius(3);
		testProjectileAttrs.setRange(500);
		testProjectileAttrs.setType("pellet");
		
		sprites = new BufferedImage[1];
		try {
			sprites[0] = ImageIO.read(new File("Images/Pellet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ProjectileFactory.CreateProjectileType("pellet", testProjectileAttrs, sprites);
		
		sprites = new BufferedImage[1];
		try {
			sprites[0] = ImageIO.read(new File("Images/MM.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		testProjectileAttrs = new ProjectileAttributes();
		
		testProjectileAttrs.setDamage(20);
		testProjectileAttrs.setMass(1);
		testProjectileAttrs.setRadius(5);
		testProjectileAttrs.setRange(700);
		testProjectileAttrs.setType("magicMissile");
		
		ProjectileFactory.CreateProjectileType("magicMissile", testProjectileAttrs, sprites);
		
		GenericUnitFactory.CreateUnit("test", new Point(10, 10), new Vector(0.005, 0), Force.BLUE).register();
		GenericUnitFactory.CreateUnit("test", new Point(100, 100), new Vector(0.005, 180), Force.BLUE).register();
		GenericUnitFactory.CreateUnit("test", new Point(690, 100), new Vector(0.005, 0), Force.BLUE).register();
		GenericUnitFactory.CreateUnit("test", new Point(600, 190), new Vector(0.005, 180), Force.BLUE).register();
		
		GenericUnitFactory.CreateUnit("test", new Point(600, 790), new Vector(0.005, 180), Force.BLUE).register();
		GenericUnitFactory.CreateUnit("test", new Point(600, 890), new Vector(0.005, 180), Force.BLUE).register();
		GenericUnitFactory.CreateUnit("test", new Point(600, 990), new Vector(0.005, 180), Force.BLUE).register();
		GenericUnitFactory.CreateUnit("test", new Point(600, 1090), new Vector(0.005, 180), Force.BLUE).register();
		
		GenericUnitFactory.CreateUnit("Beholder", new Point(300, 190), new Vector(0.005, 180), Force.GREEN).register();
		GenericUnitFactory.CreateUnit("Beholder", new Point(100, 390), new Vector(0.005, 180), Force.GREEN).register();
		//new GenericUnit(new Point(10, 10), new Vector(0.005, 0), Force.RED).register();
		//new GenericUnit(new Point(100, 100), new Vector(0.005, 180), Force.BLUE).register();
	}
	
	public JLabel label;

	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		
		if (event.equals("Up")) {
			game.shiftY(-100);
		}
		else if (event.equals("Down")) {
			game.shiftY(100);
		}
		else if (event.equals("Left")) {
			game.shiftX(-100);
		}
		else if (event.equals("Right")) {
			game.shiftX(100);		
		}
		else if (event.equals("Zoom In")) {
			game.zoomIn(0.1);
		}
		else if (event.equals("Zoom Out")) {
			game.zoomOut(0.1);
		}
	}
}
