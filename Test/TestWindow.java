package Test;

import java.awt.BorderLayout;
import java.awt.Color;
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
import Test.MovingStrategies.TargetAndCircle;
import Test.Projectiles.LazerBeamAttributes;
import Test.Projectiles.LazerBeamFactory;
import Test.Projectiles.ProjectileAttributes;
import Test.Projectiles.ProjectileFactory;
import Test.ShootingStrategies.CircularShootingStrategy;
import Test.Units.GenericSpawner;
import Test.Units.GenericSpawnerAttributes;
import Test.Units.GenericSpawnerFactory;
import Test.Units.GenericUnitAttributes;
import Test.Units.GenericUnitFactory;

public class TestWindow extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameWindow game;
	
	public static void main(String[] args) {
		TestWindow theGame = new TestWindow();
		theGame.game = new GameWindow();
		
		theGame.setSize(GameWindow.WIDTH, GameWindow.HEIGHT);
		theGame.setLayout(new BorderLayout());
		theGame.add(theGame.game, BorderLayout.CENTER);
		theGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theGame.setVisible(true);
		
		theGame.label = new JLabel("HOWDY");
		theGame.add(theGame.label, BorderLayout.SOUTH);
		
		JPanel mainPanel = new JPanel();
		
		JButton in = new JButton("Zoom In");		
		in.addActionListener(theGame);
		
		JButton out = new JButton("Zoom Out");
		out.addActionListener(theGame);
		
		JButton up = new JButton("Up");
		up.addActionListener(theGame);
		
		JButton down = new JButton("Down");
		down.addActionListener(theGame);
		
		JButton left = new JButton("Left");
		left.addActionListener(theGame);
		
		JButton right = new JButton("Right");
		right.addActionListener(theGame);
		
		mainPanel.add(in);
		mainPanel.add(out);
		
		JPanel shiftPanel = new JPanel(new BorderLayout());
		
		shiftPanel.add(up, BorderLayout.NORTH);
		shiftPanel.add(down, BorderLayout.SOUTH);
		shiftPanel.add(left, BorderLayout.WEST);
		shiftPanel.add(right, BorderLayout.EAST);
		
		mainPanel.add(shiftPanel);
		
		theGame.add(mainPanel, BorderLayout.SOUTH);
		
		theGame.initUnits();
		theGame.initProjectiles();
	
		/*GenericUnitFactory.createUnit("test", new Point(210, 10), new Vector(0.005, 0), Force.GREEN).register();
		GenericUnitFactory.createUnit("test", new Point(2100, 100), new Vector(0.005, 180), Force.GREEN).register();
		GenericUnitFactory.createUnit("test", new Point(2690, 100), new Vector(0.005, 0), Force.GREEN).register();
		GenericUnitFactory.createUnit("test", new Point(2600, 190), new Vector(0.005, 180), Force.GREEN).register();
		
		GenericUnitFactory.createUnit("test", new Point(2600, 790), new Vector(0.005, 180), Force.GREEN).register();
		GenericUnitFactory.createUnit("test", new Point(2600, 890), new Vector(0.005, 180), Force.GREEN).register();
		GenericUnitFactory.createUnit("test", new Point(2600, 990), new Vector(0.005, 180), Force.GREEN).register();
		GenericUnitFactory.createUnit("test", new Point(2600, 1090), new Vector(0.005, 180), Force.GREEN).register();
		
		GenericUnitFactory.createUnit("Beholder", new Point(300, 190), new Vector(0.005, 180), Force.GREEN).register();
		GenericUnitFactory.createUnit("Beholder", new Point(100, 390), new Vector(0.005, 180), Force.GREEN).register();
		GenericUnitFactory.createUnit("Beholder", new Point(150, 390), new Vector(0.005, 180), Force.GREEN).register();
		GenericUnitFactory.createUnit("Beholder", new Point(200, 390), new Vector(0.005, 180), Force.GREEN).register();
		GenericUnitFactory.createUnit("Beholder", new Point(300, 390), new Vector(0.005, 180), Force.GREEN).register();
		GenericUnitFactory.createUnit("Beholder", new Point(100, 490), new Vector(0.005, 180), Force.GREEN).register();*/
		GenericSpawnerFactory.createUnit("ZombieBoat", new Point(400, 490), new Vector(0.005, 180), Force.GREEN).register();
		GenericSpawnerFactory.createUnit("ZombieBoat", new Point(500, 490), new Vector(0.005, 180), Force.GREEN).register();
		GenericSpawnerFactory.createUnit("BeholderBoat", new Point(700, 590), new Vector(0.005, 180), Force.GREEN).register();
		GenericSpawnerFactory.createUnit("BeholderBoat", new Point(2600, 490), new Vector(0.005, 180), Force.BLUE).register();
		turrets(2500, 500, Force.BLUE);
		turrets(3000, 500, Force.BLUE);
		turrets(2500, 1100, Force.BLUE);
		turrets(3000, 1100, Force.BLUE);
		GenericSpawner bluePlanet = (GenericSpawner) GenericSpawnerFactory.createUnit("Planet", new Point(2850, 1000), new Vector(), Force.BLUE);
		GenericSpawnerFactory factory = new GenericSpawnerFactory("BeholderSpawner");
		bluePlanet.changeFactory(factory);
		bluePlanet.setSpawnType("BeholderBoat");
		bluePlanet.setSpawnRate(5000);
		bluePlanet.register();
		
		GenericSpawnerFactory.createUnit("ZombieBoat", new Point(7400, 7490), new Vector(0.005, 180), Force.RED).register();
		GenericSpawnerFactory.createUnit("ZombieBoat", new Point(7500, 7490), new Vector(0.005, 180), Force.RED).register();
		GenericSpawnerFactory.createUnit("BeholderBoat", new Point(7700, 7590), new Vector(0.005, 180), Force.RED).register();
		GenericSpawnerFactory.createUnit("BeholderBoat", new Point(7700, 7590), new Vector(0.005, 180), Force.RED).register();
		GenericSpawnerFactory.createUnit("ZombieBoat", new Point(7500, 7590), new Vector(0.005, 180), Force.RED).register();
		
		GenericSpawnerFactory.createUnit("ZombieBoat", new Point(8400, 7490), new Vector(0.005, 180), Force.RED).register();
		GenericSpawnerFactory.createUnit("ZombieBoat", new Point(8500, 7490), new Vector(0.005, 180), Force.RED).register();
		GenericSpawnerFactory.createUnit("BeholderBoat", new Point(8700, 7590), new Vector(0.005, 180), Force.RED).register();
		GenericSpawnerFactory.createUnit("BeholderBoat", new Point(8700, 7590), new Vector(0.005, 180), Force.RED).register();
		GenericSpawnerFactory.createUnit("ZombieBoat", new Point(8500, 7590), new Vector(0.005, 180), Force.RED).register();
		
		GenericSpawnerFactory.createUnit("ZombieBoat", new Point(7400, 8490), new Vector(0.005, 180), Force.RED).register();
		GenericSpawnerFactory.createUnit("ZombieBoat", new Point(7500, 8490), new Vector(0.005, 180), Force.RED).register();
		GenericSpawnerFactory.createUnit("BeholderBoat", new Point(7700, 8590), new Vector(0.005, 180), Force.RED).register();
		GenericSpawnerFactory.createUnit("BeholderBoat", new Point(7700, 8590), new Vector(0.005, 180), Force.RED).register();
		GenericSpawnerFactory.createUnit("ZombieBoat", new Point(7500, 8590), new Vector(0.005, 180), Force.RED).register();
		
		GenericSpawnerFactory.createUnit("ZombieBoat", new Point(7400, 9490), new Vector(0.005, 180), Force.RED).register();
		GenericSpawnerFactory.createUnit("ZombieBoat", new Point(7500, 9490), new Vector(0.005, 180), Force.RED).register();
		GenericSpawnerFactory.createUnit("BeholderBoat", new Point(7700, 9590), new Vector(0.005, 180), Force.RED).register();
		GenericSpawnerFactory.createUnit("BeholderBoat", new Point(7700, 9590), new Vector(0.005, 180), Force.RED).register();
		GenericSpawnerFactory.createUnit("ZombieBoat", new Point(7500, 9590), new Vector(0.005, 180), Force.RED).register();
		
		for (int i = 0; i < 2; i++) {
			GenericSpawner redPlanet = (GenericSpawner) GenericSpawnerFactory.createUnit("Planet", new Point(9000 + (120 * i), 9000 + (120 * i)), new Vector(), Force.RED);
			GenericSpawnerFactory fa = new GenericSpawnerFactory("ZombieBoat");
			redPlanet.changeFactory(fa);
			redPlanet.setSpawnType("ZombieBoat");
			redPlanet.setSpawnRate(20000);
			redPlanet.register();
		}
		
		
		//GenericSpawnerFactory.createUnit("ZombieBoat", new Point(700, 490), new Vector(0.005, 180), Force.GREEN).register();
		//GenericSpawnerFactory.createUnit("ZombieBoat", new Point(800, 490), new Vector(0.005, 180), Force.GREEN).register();
		//GenericSpawnerFactory.createUnit("ZombieBoat", new Point(900, 490), new Vector(0.005, 180), Force.GREEN).register();
		
		
	}
	
	public static void setUpBattle() {
		
	}
	
	public static void turrets(int startx, int starty, Force team) {
		GenericUnitFactory.createUnit("BasicTurret", new Point(startx      , starty + 300), new Vector(), team).register();
		GenericUnitFactory.createUnit("BasicTurret", new Point(startx + 100, starty      ), new Vector(), team).register();
		GenericUnitFactory.createUnit("BasicTurret", new Point(startx + 200, starty + 150), new Vector(), team).register();
		GenericUnitFactory.createUnit("BasicTurret", new Point(startx      , starty + 150), new Vector(), team).register();
		GenericUnitFactory.createUnit("BasicTurret", new Point(startx + 100, starty + 450), new Vector(), team).register();
		GenericUnitFactory.createUnit("BasicTurret", new Point(startx + 200, starty + 300), new Vector(), team).register();
		GenericUnitFactory.createUnit("DeathStar",   new Point(startx + 100, starty + 200), new Vector(), team).register();
		GenericUnitFactory.createUnit("DeathStar",   new Point(startx + 100, starty + 300), new Vector(), team).register();
	}
	
	public JLabel label;

	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		
		if (event.equals("Up")) {
			game.shiftY(-250);
		}
		else if (event.equals("Down")) {
			game.shiftY(250);
		}
		else if (event.equals("Left")) {
			game.shiftX(-250);
		}
		else if (event.equals("Right")) {
			game.shiftX(250);		
		}
		else if (event.equals("Zoom In")) {
			game.zoomIn(0.075);
		}
		else if (event.equals("Zoom Out")) {
			game.zoomOut(0.075);
		}
	}
	
	private void initUnits() {
		initZombie();
		initBeholder();
		initTurret();
		initDeathStar();
		initZombieBoat();
		initBeholderBoat();
		initPlanet();
	}
	
	private void initProjectiles() {
		initPellet();
		initMM();
		initBLB();
		initGLB();
		initRLB();
	}
	
	private void initPlanet() {
		BufferedImage[] sprites = new BufferedImage[1];
		
		try {
			sprites[0] = ImageIO.read(new File("Images/Planet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GenericSpawnerAttributes sAttrs = new GenericSpawnerAttributes();
		
		sAttrs.setMass(10000);
		sAttrs.setMaxHitPoints(5000);
		sAttrs.setRadius(40);
		sAttrs.setType("Planet");
		sAttrs.setShootingStrategy(null);
		sAttrs.setMaxVelocity(1.5);
		sAttrs.setMovingStrategy(null);
		
		GenericUnitFactory factory = new GenericUnitFactory("Beholder");
		sAttrs.setFactory(factory);
		sAttrs.setRate(15000);
		sAttrs.setSpawnType("Beholder");
		
		GenericUnitFactory.CreateUnitType("Planet", sAttrs, sprites);
	}
	
	private void initBeholderBoat() {
		BufferedImage[] sprites = new BufferedImage[1];
		
		try {
			sprites[0] = ImageIO.read(new File("Images/BatBoat.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GenericSpawnerAttributes sAttrs = new GenericSpawnerAttributes();
		
		sAttrs.setMass(150);
		sAttrs.setMaxHitPoints(400);
		sAttrs.setRadius(25);
		sAttrs.setType("BeholderBoat");
		sAttrs.setShootingStrategy(new CircularShootingStrategy(20, 2000, 20, 500, new LazerBeamFactory("RedLazer")));
		sAttrs.setMaxVelocity(1.5);
		sAttrs.setMovingStrategy(new TargetAndCircle(1500, 30, 45, true));
		
		GenericUnitFactory factory = new GenericUnitFactory("Beholder");
		sAttrs.setFactory(factory);
		sAttrs.setRate(15000);
		sAttrs.setSpawnType("Beholder");
		
		GenericUnitFactory.CreateUnitType("BeholderBoat", sAttrs, sprites);
	}
	
	private void initZombieBoat() {
		BufferedImage[] sprites = new BufferedImage[1];
		
		try {
			sprites[0] = ImageIO.read(new File("Images/BatBoat.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GenericSpawnerAttributes sAttrs = new GenericSpawnerAttributes();
		
		sAttrs.setMass(150);
		sAttrs.setMaxHitPoints(400);
		sAttrs.setRadius(25);
		sAttrs.setType("ZombieBoat");
		sAttrs.setShootingStrategy(new CircularShootingStrategy(20, 2000, 20, 500, new LazerBeamFactory("RedLazer")));
		sAttrs.setMaxVelocity(1.5);
		sAttrs.setMovingStrategy(new TargetAndCircle(1500, 30, 45, true));
		
		GenericUnitFactory factory = new GenericUnitFactory("test");
		sAttrs.setFactory(factory);
		sAttrs.setRate(4500);
		sAttrs.setSpawnType("test");
		
		GenericUnitFactory.CreateUnitType("ZombieBoat", sAttrs, sprites);
	}
	
	private void initBeholder() {
		BufferedImage[] sprites = new BufferedImage[5];
		
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
		
		GenericUnitAttributes testAttrs = new GenericUnitAttributes();
		
		testAttrs.setMass(50);
		testAttrs.setMaxHitPoints(200);
		testAttrs.setRadius(35);
		testAttrs.setType("Beholder");
		testAttrs.setShootingStrategy(new CircularShootingStrategy(10, 1500, 40, 600, new ProjectileFactory("magicMissile")));
		testAttrs.setMaxVelocity(2);
		testAttrs.setMovingStrategy(new TargetAndCircle(500, 30, 25, false));
		
		GenericUnitFactory.CreateUnitType("Beholder", testAttrs, sprites);
	}
	
	private void initZombie() {
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
		
		testAttrs.setMass(3);
		testAttrs.setMaxHitPoints(55);
		testAttrs.setRadius(20);
		testAttrs.setType("test");
		testAttrs.setShootingStrategy(new CircularShootingStrategy(3, 500, 20, 400, new ProjectileFactory("pellet")));
		testAttrs.setMaxVelocity(3.5);
		
		testAttrs.setMovingStrategy(new TargetAndCircle(50, 2, 5, true));
		
		GenericUnitFactory.CreateUnitType("test", testAttrs, sprites);
	}
	
	private void initTurret() {
		BufferedImage[] sprites = new BufferedImage[2];
		
		try {
			sprites[0] = ImageIO.read(new File("Images/Turret2.png"));
			sprites[1] = ImageIO.read(new File("Images/Turret.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GenericUnitAttributes testAttrs = new GenericUnitAttributes();
		testAttrs.setMass(5000);
		testAttrs.setMaxHitPoints(1000);
		testAttrs.setRadius(50);
		testAttrs.setType("BasicTurret");
		testAttrs.setShootingStrategy(new CircularShootingStrategy(10, 250, 50, 800, new LazerBeamFactory("BlueLazer")));
		testAttrs.setMaxVelocity(2);
		
		GenericUnitFactory.CreateUnitType("BasicTurret", testAttrs, sprites);
	}
	
	private void initDeathStar() {
		BufferedImage[] sprites = new BufferedImage[2];
		
		try {
			sprites[0] = ImageIO.read(new File("Images/Turret2.png"));
			sprites[1] = ImageIO.read(new File("Images/Turret.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GenericUnitAttributes testAttrs = new GenericUnitAttributes();
		testAttrs.setMass(5000);
		testAttrs.setMaxHitPoints(700);
		testAttrs.setRadius(45);
		testAttrs.setType("DeathStar");
		testAttrs.setShootingStrategy(new CircularShootingStrategy(20, 6000, 50, 1250, new LazerBeamFactory("GreenLazer")));
		testAttrs.setMaxVelocity(2);
		
		GenericUnitFactory.CreateUnitType("DeathStar", testAttrs, sprites);
	}
	
	private void initPellet() {
		ProjectileAttributes testProjectileAttrs = new ProjectileAttributes();
		
		testProjectileAttrs.setDamage(5);
		testProjectileAttrs.setMass(1);
		testProjectileAttrs.setRadius(3);
		testProjectileAttrs.setRange(500);
		testProjectileAttrs.setType("pellet");
		
		BufferedImage[] sprites = new BufferedImage[1];
		try {
			sprites[0] = ImageIO.read(new File("Images/Pellet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ProjectileFactory.CreateProjectileType("pellet", testProjectileAttrs, sprites);
		
	}
	
	private void initMM() {
		BufferedImage[] sprites = new BufferedImage[1];
		try {
			sprites[0] = ImageIO.read(new File("Images/MM.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ProjectileAttributes testProjectileAttrs = new ProjectileAttributes();
		
		testProjectileAttrs.setDamage(20);
		testProjectileAttrs.setMass(1);
		testProjectileAttrs.setRadius(5);
		testProjectileAttrs.setRange(700);
		testProjectileAttrs.setType("magicMissile");
		
		ProjectileFactory.CreateProjectileType("magicMissile", testProjectileAttrs, sprites);
	}
	
	private void initBLB() {
		LazerBeamAttributes lazerAttrs = new LazerBeamAttributes();
		
		lazerAttrs.setDamage(3);
		lazerAttrs.setMass(1);
		lazerAttrs.setRadius(10);
		lazerAttrs.setRange(900);
		lazerAttrs.setType("BlueLazer");
		lazerAttrs.setColour(Color.BLUE);
		
		ProjectileFactory.CreateProjectileType("BlueLazer", lazerAttrs, null);
	}
	
	private void initGLB() {
		LazerBeamAttributes lazerAttrs = new LazerBeamAttributes();
		
		lazerAttrs.setDamage(50);
		lazerAttrs.setMass(1);
		lazerAttrs.setRadius(30);
		lazerAttrs.setRange(1500);
		lazerAttrs.setType("GreenLazer");
		lazerAttrs.setColour(Color.GREEN);
		
		ProjectileFactory.CreateProjectileType("GreenLazer", lazerAttrs, null);
	}
	
	private void initRLB() {
		LazerBeamAttributes lazerAttrs = new LazerBeamAttributes();
		
		lazerAttrs.setDamage(15);
		lazerAttrs.setMass(1);
		lazerAttrs.setRadius(20);
		lazerAttrs.setRange(1000);
		lazerAttrs.setType("RedLazer");
		lazerAttrs.setColour(Color.RED);
		
		ProjectileFactory.CreateProjectileType("RedLazer", lazerAttrs, null);
	}
}
