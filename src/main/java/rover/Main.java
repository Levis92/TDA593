package rover;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import project.AbstractSimulatorMonitor;
import project.Point;


public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		MyEnv e = new MyEnv();
		
		//Rovers Initialization
		Set<Rover> robots = new HashSet<>();
		
		Rover robot1 = new Rover(new Point(-8, -3.5), "Robot 1");
		Rover robot2 = new Rover(new Point(-8, 3.5), "Robot 2");
		Rover robot3 = new Rover(new Point(8, 3.5), "Robot 3");
		Rover robot4 = new Rover(new Point(8, -3.5), "Robot 4");
		
		robots.add(robot3);
		robots.add(robot2);
		robots.add(robot1);
		robots.add(robot4);
		
		//AreaController Initialization
		List<AreaController> listAreaController = new ArrayList<AreaController>();
		
		AreaController aC1 = new AreaController ( new Point(-3.5,3.5), 3.5 ,e);
		AreaController aC2 = new AreaController ( new Point(3.5,3.5), 3.5 ,e);
		AreaController aC3 = new AreaController ( new Point(-3.5,-3.5), 3.5 ,e);
		AreaController aC4 = new AreaController ( new Point(3.5,-3.5), 3.5 ,e);
		
		listAreaController.add(aC1);
		listAreaController.add(aC2);
		listAreaController.add(aC3);
		listAreaController.add(aC4);
		
		//Missions Initialization
		LinkedList<Point> point1 = new LinkedList<Point>();
		point1.add(new Point(-3.5,-3.5));
		point1.add(new Point(3.5, -3.5));
		point1.add(new Point(8, -3.5));
		
		LinkedList<Point> point2 = new LinkedList<Point>();
		point2.add(new Point(-3.5, 3.5));
		point2.add(new Point(-3.5, -3.5));
		point2.add(new Point(-8, -3.5));
		
		LinkedList<Point> point3 = new LinkedList<Point>();
		point3.add(new Point(3.5,3.5));
		point3.add(new Point(-3.5,3.5));
		point3.add(new Point(-8, 3.5));
		
		LinkedList<Point> point4 = new LinkedList<Point>();
		point4.add(new Point(3.5, -3.5));
		point4.add(new Point(3.5, 3.5));
		point4.add(new Point(8, 3.5));
		
		Mission mission1 = new Mission(point1);
		Mission mission2 = new Mission(point2);
		Mission mission3 = new Mission(point3);
		Mission mission4 = new Mission(point4);
		
		AccessManager accessManager = new AccessManager(listAreaController);
		AbstractSimulatorMonitor<Rover> controller = new SimulatorMonitor(robots, e, accessManager);
		
		robot1.provideMission(mission1, null);
		robot2.provideMission(mission2, null);
		robot3.provideMission(mission3, null);
		robot4.provideMission(mission4, null);
		
		
		System.out.println(mission1.getPointsToReach());
		
		
		
	}
}
