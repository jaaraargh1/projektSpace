package logics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

public abstract class Alien extends Sprite {

	private boolean isAlive = true;
	public static int numAlive;
	private int spdY;
	private int spdX;
	private Random r;
	private int damage;
	private int value;
	private int health;

	public Alien(Image i, int health) {
		super(i);
		r = new Random();
		this.setAlive(true);
		setPosition((r.nextInt(800)), r.nextInt(20));
		this.damage = 5;
		spdX = 0;
		spdY = 2;
		this.value = 50;
		this.health = health;
	}

	public abstract void move();

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 50, 32);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getValue() {
		return value;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int n) {
		this.health = n;
	}

}
