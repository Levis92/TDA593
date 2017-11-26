package rover;

import java.util.HashSet;
import java.util.Set;

import project.AbstractSimulatorMonitor;
import project.LocationController;
import project.Point;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		MyEnv e = new MyEnv();

		Set<Rover> robots = new HashSet<>();
		Rover robot1 = new Rover(new Point(8, 3.5), "Robot 1");
		Rover robot2 = new Rover(new Point(-8, 3.5), "Robot 2");
		Rover robot3 = new Rover(new Point(-8, -3.5), "Robot 3");
		Rover robot4 = new Rover(new Point(8, -3.5), "Robot 4");
		
		robots.add(robot1);
		robots.add(robot2);
		robots.add(robot3);
		robots.add(robot4);
		
		RoverList roverList = new RoverList(robots);
		
		LocationController cP1 = new LocationController ( new Point(-3.5,3.5), 3.5 ,e);
		LocationController cP2 = new LocationController ( new Point(3.5,3.5), 3.5 ,e);
		LocationController cP3 = new LocationController ( new Point(-3.5,-3.5), 3.5 ,e);
		LocationController cP4 = new LocationController ( new Point(3.5,-3.5), 3.5 ,e);
		
		//robot1.setDestination(new Point(-3.5, 3.5));
		
		
		MissionManager missionManager = new MissionManager();
		Operator operator = new Operator();
		Point[] points = {new Point(-3.5, 3.5), new Point(8, 3.5), new Point(-3.5, 3.5), new Point(8, 3.5)};
		operator.createMission(points, "Rover 1");
				
		AbstractSimulatorMonitor<Rover> controller = new SimulatorMonitor(robots, e);
		
		
		
	}
}
