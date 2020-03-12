package logics;

import java.awt.Image;
import java.awt.Rectangle;

import graphics.Game;

public class RapidFire extends PowerUp {
	private RapidFireTimer timer;
	private Player player;

	public RapidFire(Image i) {
		super(i);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 30, 47);
	}

	public void ChangeState() {
		timer = new RapidFireTimer(4);

		Player.setRateOfFire(100);

	}
}
