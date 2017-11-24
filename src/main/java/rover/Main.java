package rover;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import project.AbstractSimulatorMonitor;
import project.Point;
import simbad.sim.AbstractWall;
import simbad.sim.Boundary;
import simbad.sim.EnvironmentDescription;
import simbad.sim.HorizontalBoundary;
import simbad.sim.HorizontalWall;
import simbad.sim.VerticalBoundary;
import simbad.sim.VerticalWall;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		EnvironmentDescription e = new EnvironmentDescription();

		Color c = Color.GRAY;

		Boundary w1 = new HorizontalBoundary(-5.0f, -5.0f, 5.0f, e, c);

		Boundary w2 = new HorizontalBoundary(5.0f, -5.0f, 5.0f, e, c);

		Boundary w3 = new VerticalBoundary(5.0f, -5.0f, 5.0f, e, c);

		Boundary w4 = new VerticalBoundary(-5.0f, -5.0f, 5.0f, e, c);

		AbstractWall roomWall1 = new HorizontalWall(-1f, 4.5f, 1f, e, c);

		AbstractWall roomWall2 = new HorizontalWall(-4.5f, 4.5f, 1f, e, c);

		AbstractWall roomWall3 = new VerticalWall(4.5f, -4.5f, -1f, e, c);

		AbstractWall roomWall4 = new VerticalWall(1f, -4.5f, -1f, e, c);

		Set<RobotAvatar> robots = new HashSet<RobotAvatar>();

		RobotAvatar robot1 = new RobotAvatar(new Point(0, 0), "Robot 1");
		RobotAvatar robot2 = new RobotAvatar(new Point(1, 3), "Robot 2");

		robots.add(robot1);
		robots.add(robot2);

		AbstractSimulatorMonitor controller = new SimulatorMonitor(robots, e);

	}

}
