package logics;

import java.awt.Image;
import java.awt.Rectangle;

import graphics.Game;

public class Player extends Sprite {
	private static int health = 100;
	private static long rateOfFire = 400;
	private static long powerUp;
	private static boolean invincible = false;
	private int damage = 1;

	public Player(Image i) {
		super(i);

	}

	public static int getHealth() {
		return Player.health;
	}

	public void setHealth(int healthX) {
		Player.health = healthX;
	}

	public void move() {

		this.x += xSpeed;
		this.y += ySpeed;

	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, 54, 32);
	}

	public static long getRateOfFire() {
		return rateOfFire;
	}

	public static void setRateOfFire(long rateOfFire) {
		Player.rateOfFire = rateOfFire;
	}

	public static boolean isInvincible() {
		return invincible;
	}

	public static void setInvincible(boolean invincible) {
		Player.invincible = invincible;
	}

	public static long getPowerUp() {
		return powerUp;
	}

	public static void setPowerUp(long l) {
		Player.powerUp = l;
	}

	public int getDamage() {
		// TODO Auto-generated method stub
		return damage;
	}
}
