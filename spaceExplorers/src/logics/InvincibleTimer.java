package logics;

import java.util.Timer;
import java.util.TimerTask;

public class InvincibleTimer {
	Timer timer;

	public InvincibleTimer(int seconds) {
		timer = new Timer();
		timer.schedule(new PowerUpReminder(), seconds * 1000);
		Player.setInvincible(true);
	}

	class PowerUpReminder extends TimerTask {
		public void run() {
			Player.setInvincible(false);
			timer.cancel();
		}
	}

}