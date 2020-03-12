package logics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import graphics.Game;

public class MouseInput implements MouseListener {
	private Game game;

	public MouseInput(Game game) {
		this.game = game;
	}

	public void mousePressed(MouseEvent e) {
		long t = System.nanoTime();
		if (System.nanoTime() >= t + Player.getRateOfFire()) {
			game.fire();
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
