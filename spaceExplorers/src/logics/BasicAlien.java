package logics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

public class BasicAlien extends Alien {

	private boolean isAlive = true;
	public static int numAlive;
	private int spdY;
	private int spdX;
	private Random r;
	private int damage;
	private int value;
	private int health = 5;

	public BasicAlien(Image i, int health) {
		super(i, health);
		r = new Random();
		this.setAlive(true);
		setPosition((r.nextInt(800)), r.nextInt(20));
		this.damage = 5;
		spdX = 0;
		spdY = 2;
		this.value = 50;
	}

	public void move() {

		x += spdX;
		y += spdY;
		if (y <= 0 || y >= 580) {
			spdX = 1;
		}

		if (x <= 0 || x > 780) {
			spdX *= -1;

		}

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

}
