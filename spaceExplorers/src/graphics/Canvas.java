package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Iterator;

import logics.Alien;
import logics.Bullet;
import logics.Player;
import logics.PowerUp;

public class Canvas {
	private Game game;
	private int score;
	private static int level;
	private Player player;
	private int highscore;

	public Canvas(Game game, int score, int level, int highscore, Player player) {
		this.game = game;
		this.score = score;
		this.level = level;
		this.highscore = highscore;
		this.player = player;
	}

	public void paintBullets(Graphics g) {
		Iterator<Bullet> iterator = game.getBullets().iterator();
		while (iterator.hasNext()) {
			Bullet playerBullet = (Bullet) iterator.next();
			if (playerBullet.isVisible())
				playerBullet.paint(g);
		}

	}

	public static int getLevel() {
		return level;
	}

	public int getScore() {
		return score;
	}

	public static void setLevel(int i) {
		Canvas.level = level + i;
	}

	public void paintMenu(Graphics g) {

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 800, 600);
		Font f = new Font("Times", Font.ROMAN_BASELINE, 14);
		g.setFont(f);
		g.setColor(Color.BLACK);
		g.drawString("tryck valfri tangent ", 265, 300);
		g.drawString("<Rör dig med pilarna, skjut med musen> ", 205, 350);

	}

	public void paintPowerUps(Graphics g) {
		for (PowerUp p : game.getPowerUps()) {

			p.paint(g);
		}

	}

	public void paintAlien(Graphics g) {
		for (Alien a : game.getAliensArray()) {
			a.paint(g);
		}

	}

	public void setScore(int n) {

		this.score = score + n;
	}

	public void paintHud(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(15, 45, 200, 60);
		g.setColor(Color.green);
		g.fillRect(15, 45, Player.getHealth() * 2, 60);
		g.fillRect(15, 45, Player.getHealth(), 60);
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(15, 45, 200, 60);
		g.drawString("Score:" + score++, 15, 140);
		g.drawString("Level:" + level, 15, 170);

		Font f = new Font("Times", Font.PLAIN, 24);
		g.setFont(f);

		g.drawString("HighScore " + highscore, 440, 60);

	}

}
