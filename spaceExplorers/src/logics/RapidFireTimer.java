package logics;

import java.util.Timer;
import java.util.TimerTask;

public class RapidFireTimer {
	Timer timer;
	private Player player;

	public RapidFireTimer(int seconds) {
		timer = new Timer();
		timer.schedule(new PowerUpReminder(), seconds * 1000);
		Player.setRateOfFire(100);
	}

	class PowerUpReminder extends TimerTask {
		public void run() {
			Player.setRateOfFire(400);
			timer.cancel();
		}
	}

}