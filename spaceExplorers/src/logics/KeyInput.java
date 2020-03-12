package logics;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import graphics.*;

public class KeyInput extends KeyAdapter {

	private Player player;
	private boolean uP = false;
	private boolean dP = false;
	private boolean lP = false;
	private boolean rP = false;
	private int MovementSpeed = 4;

	public KeyInput(Player player) {
		this.player = player;
	}

	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		int temp = 4;
		Game.changeGameState();
		switch (k) {
		case KeyEvent.VK_UP:
			uP = true;
			player.setYSpeed(-temp);
			break;
		case KeyEvent.VK_DOWN:
			dP = true;
			player.setYSpeed(temp);
			break;
		case KeyEvent.VK_LEFT:
			lP = true;
			player.setXSpeed(-temp);
			break;
		case KeyEvent.VK_RIGHT:
			rP = true;
			player.setXSpeed(temp);

			break;
		case KeyEvent.VK_ESCAPE:
			System.exit(1);
		}

	}

	public void keyReleased(KeyEvent e) {
		int k = e.getKeyCode();
		switch (k) {
		case KeyEvent.VK_UP:
			uP = false;
			if (dP == true) {
				player.setYSpeed(MovementSpeed);
			} else {
				player.setYSpeed(0);
			}
			break;
		case KeyEvent.VK_DOWN:
			dP = false;
			if (uP) {

				player.setYSpeed(MovementSpeed);
			} else {
				player.setYSpeed(0);

			}
			break;
		case KeyEvent.VK_RIGHT:
			rP = false;
			if (lP) {

				player.setXSpeed(-MovementSpeed);
			} else {
				player.setXSpeed(0);

			}  
			break;
		case KeyEvent.VK_LEFT:
			lP = false;
			if (rP) {

				player.setXSpeed(MovementSpeed);
			} else {
				player.setXSpeed(0);

			}
			break;
		}
	}
}
