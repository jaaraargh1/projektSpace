package logics;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Iterator;

public class Bullet extends Sprite {
	protected int yVel = 15;
	private boolean isVisible = true;

	public boolean isVisible() {
		return isVisible;
	}

	
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public int getyVel() {
		return yVel;
	}

	public Bullet(Image i) {
		super(i);
	}

	public boolean move() {
		this.y -= yVel;
		return true;

	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 6, 16);	}



}
