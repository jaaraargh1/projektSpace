package graphics;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import logics.*;
import javax.swing.*;

public class Game extends JFrame implements Runnable {
	static String dir;
	private static boolean loadedPictures = false;
	private static final Dimension WindowSize = new Dimension(800, 600);
	private ArrayList<Alien> AliensArray;
	private Canvas canvas;
	private Player player;
	private BufferStrategy strategy;
	private Graphics outOfBoundsGraphics;
	private ArrayList<Bullet> bullets;
	private int score = 0;
	private int highscore;
	private static boolean currentStatus = true;
	private int level = 1;
	private ImageIcon icon = new ImageIcon(dir + "\\alien.png");
	private LevelSpawn spawner;
	private ImageIcon icon1 = new ImageIcon(dir + "\\alien.png");
	private int width;
	private int height;
	private Color currentColor = Color.black;
	private ArrayList<PowerUp> powerUps;
	private Random r;

	public Game() {

		setLayout(new BorderLayout());
		powerUps = new ArrayList<PowerUp>();
		spawner = new LevelSpawn(this);
		canvas = new Canvas(this, score, level, highscore, player);
		bullets = new ArrayList<Bullet>();
		AliensArray = new ArrayList<Alien>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(width, height, WindowSize.width, WindowSize.height);
		setVisible(true);
		setTitle("Quasi space invaders");

		icon1 = new ImageIcon(dir + "\\alien.png");
		icon = new ImageIcon(dir + "\\player.png");
		Image shipImage = icon.getImage();
		player = new Player(shipImage);
		player.setPosition(400, 550);
		Sprite.setWinWidth(WindowSize.width);
		addKeyListener(new KeyInput(player));
		addMouseListener(new MouseInput(this));
		startNewGame(); // startar ny session
		Thread t = new Thread(this);
		t.start(); // kicka igång tråden
		createBufferStrategy(2); // cachar / buffrar bilder
		strategy = getBufferStrategy();
		outOfBoundsGraphics = strategy.getDrawGraphics();
		loadedPictures = true; // boolean test för att kunna printa bilder

	}

	public ArrayList<Alien> getAliensArray() {
		return AliensArray;
	}

	public void run() {
		while (true) {

			score++;
			if (currentStatus) {
				repaint();
			}
			try {
				Thread.sleep(18); // söver tråden
			} catch (InterruptedException e) {
			}

			player.move();
			spawner.spawnMonster();
			flyingBullets();
			alienMove();
			repaint();
			playerCollisionAlien();
			bulletCollision();
			playerCollisionPowerUp();
		}
	}

	public void flyingBullets() {
		Iterator<Bullet> tmp = bullets.iterator();

		while (tmp.hasNext()) {
			Bullet b = (Bullet) tmp.next();
			b.move();

		}

	}

	public void playerCollisionPowerUp() {
		for (PowerUp p : powerUps) {
			if (p.isColliding(player) && p.isVisible()) {
				p.setVisible(false);
				p.ChangeState();
			}
		}
	}

	public void playerCollisionAlien() {
		for (Alien b : AliensArray) {
			if (b.isColliding(player) && b.isVisible() && player.isInvincible() == false) {
				player.setHealth(Player.getHealth() - b.getDamage());
				if (Player.getHealth() == 0) {

					System.exit(1);
				}

			}
		}

	}

	public void bulletCollision() {
		double rand = Math.random();
		for (Alien a : AliensArray)
			for (Bullet b : bullets) {

				if (b.isColliding(a) && a.isVisible()) {
					b.setVisible(false);
					a.setHealth(a.getHealth() - player.getDamage());
					System.out.println((a.getHealth() - player.getDamage()));
					if (a.getHealth() <= 0)
						a.setVisible(false);
					canvas.setScore(a.getValue());
					if (rand < 0.06 && a.getHealth() <= 0) {
						spawnPowerUp();
						powerUps.get(powerUps.size() - 1).setPosition(a.getX(), a.getY());

					}
				}

			}

	}

	public void alienMove() {
		Iterator<Alien> tmp = AliensArray.iterator();

		while (tmp.hasNext()) {
			Alien b = (Alien) tmp.next();
			b.move();

		}

	}

	public void addAlien() {
		icon1 = new ImageIcon(dir + "\\alien.png");
		Image alienImg = icon1.getImage();
		AliensArray.add(new BasicAlien(alienImg, 5));

		icon1 = new ImageIcon(dir + "\\StrongAlien.png");
		Image StrongAlienImg = icon1.getImage();
		AliensArray.add(new StrongAlien(StrongAlienImg, 20));

	}

	public void spawnPowerUp() {
		Random randomGenerator = new Random();

		int tmpInt = randomGenerator.nextInt(2);
		if (tmpInt == 1) {
			icon1 = new ImageIcon(dir + "\\Haste.png");
			Image hasteImg = icon1.getImage();
			powerUps.add(new RapidFire(hasteImg));
		} else if (tmpInt == 0) {
			icon1 = new ImageIcon(dir + "\\Invincible.png");
			Image Invincible = icon1.getImage();
			powerUps.add(new Invincible(Invincible));
		}
	}

	private void startNewGame() {
		Game.currentStatus = true;
		score = 0;
	}

	public static void changeGameState() {
		if (currentStatus == true) {
			Game.currentStatus = false;
		}
	}

	public void fire() {

		ImageIcon pic = new ImageIcon(dir + "\\shot.png");
		Image bI = pic.getImage();
		Bullet b = new Bullet(bI);
		b.setI(bI);
		b.setPosition(player.getX() + 54 / 2, player.getY());
		bullets.add(b);
		b.move();
	}

	public void paint(Graphics g) {
		if (currentStatus == false) {
			if (loadedPictures == false)
				return;
			g = outOfBoundsGraphics;
			g.setColor(currentColor);
			g.fillRect(0, 0, WindowSize.width, WindowSize.height);
			player.paint(g);
			canvas.paintBullets(g);
			canvas.paintHud(g);
			canvas.paintAlien(g);
			canvas.paintPowerUps(g);
			strategy.show();

		}
		if (currentStatus == true) {
			canvas.paintMenu(g);
		}
	}

	public ArrayList<Bullet> getBullets() {
		return bullets;
	}

	public void setCurrentColor(Color color) {
		this.currentColor = color;
	}

	public ArrayList<PowerUp> getPowerUps() {
		return powerUps;
	}

	public void setPowerUps(ArrayList<PowerUp> powerUps) {
		this.powerUps = powerUps;
	}

	public static void main(String[] args) {
		Game.dir = System.getProperty("user.dir"); // SUPER SMART FÖR ATT LADDA IN BILDER!
		Game w = new Game();

	}
}
