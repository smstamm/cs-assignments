package cs;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Mission12Stamm - a robot by (your name here)
 */
public class Mission12Stamm extends Robot
{
	int turnDirection = 1;
	/**
	 * run: Mission12Stamm's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		setColors(
			Color.red, // body
			Color.black, // gun
			Color.white, // radar
			Color.red, // bullet
			Color.red // scanner
		);

		// Robot main loop
		while(true) {
			turnGunRight(360);
			ahead(50);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		if (e.getDistance() <= 300) {
			fire(Rules.MAX_BULLET_POWER);
		}
		else {
			fire(1);
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		turnRight(45);
		ahead(75);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		turnRight(90);
	}
	
	/**
	 * onHitRobot: What to do when you hit another robot
	 */
	public void onHitRobot(HitRobotEvent e) {
		back(25);
		turnRight(e.getBearing()); 
		fire(Rules.MAX_BULLET_POWER);
	}
}
