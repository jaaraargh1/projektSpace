package logics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class Sprite {
	protected int x;
	protected int y;
	protected int ySpeed = 0;
	protected int xSpeed = 0;
	protected Image i;
	boolean isColliding;
	private boolean isVisible = true;

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
		
		
	}

	protected static int winWidth;

	public Sprite(Image i) {
		this.i = i;

	}

	public abstract Rectangle getBounds();

	public Image getI() {
		return i;
	}

	public void setI(Image i) {
		this.i = i;
	}

	public void setPosition(int xx, int yy) {
		this.x = xx;
		this.y = yy;

	}

	public void setXSpeed(int dx) {
		xSpeed = dx;
	}

	public void setYSpeed(int dy) {
		ySpeed = dy;
	}

	public void paint(Graphics g) {
		if (isVisible) {
			g.drawImage(i, x, y, null);
		}
	}

	public static void setWinWidth(int w) {
		winWidth = w;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	

	public boolean isColliding(Sprite other) {
		isColliding = other.getBounds().intersects(this.getBounds());
		return isColliding;
	}
}
