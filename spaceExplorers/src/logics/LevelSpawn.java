package logics;

import java.awt.Color;

import graphics.Canvas;
import graphics.Game;

public class LevelSpawn {
	private Game game;
	private int scoreKeep = 0;
	private int tempLevel = 0;

	public LevelSpawn(Game game) {
		this.game = game;
		this.tempLevel = tempLevel;
	}

	public void spawnMonster() {
		scoreKeep++;

		if (scoreKeep >= 50) {
			scoreKeep = 0;
			Canvas.setLevel(1);
			tempLevel++;
			game.addAlien();
			if (tempLevel == 50) {
				game.setCurrentColor(Color.BLUE);
			}
		}

		if (scoreKeep == 30 && Canvas.getLevel() > 10) {

			game.addAlien();

		}

	}
}
