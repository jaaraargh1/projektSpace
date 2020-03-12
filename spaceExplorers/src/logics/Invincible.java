package logics;

import java.awt.Image;
import java.awt.Rectangle;

public class Invincible extends PowerUp {
	private InvincibleTimer timer;
	private Player player;

	public Invincible(Image i) {
		super(i);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 30, 47);
	}

	public void ChangeState() {
		timer = new InvincibleTimer(4);

		Player.setInvincible(true);

	}
}
