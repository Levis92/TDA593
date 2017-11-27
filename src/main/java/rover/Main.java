package rover;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import project.AbstractSimulatorMonitor;
import project.LocationController;
import project.Point;


public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		MyEnv e = new MyEnv();

		Set<RobotAvatar> robots = new HashSet<>();
		RobotAvatar robot1 = new RobotAvatar(new Point(-8, -3.5), "Robot 1");
		RobotAvatar robot2 = new RobotAvatar(new Point(-8, 3.5), "Robot 2");
		RobotAvatar robot3 = new RobotAvatar(new Point(8, 3.5), "Robot 3");
		RobotAvatar robot4 = new RobotAvatar(new Point(8, -3.5), "Robot 4");
		
		robots.add(robot1);
		robots.add(robot2);
		robots.add(robot3);
		robots.add(robot4);
		
		AreaController aC1 = new AreaController ( new Point(-3.5,3.5), 3.5 ,e);
		AreaController aC2 = new AreaController ( new Point(3.5,3.5), 3.5 ,e);
		AreaController aC3 = new AreaController ( new Point(-3.5,-3.5), 3.5 ,e);
		AreaController aC4 = new AreaController ( new Point(3.5,-3.5), 3.5 ,e);
		
		
		StrategyManager strategyManager = new StrategyManager();
		AbstractSimulatorMonitor<RobotAvatar> controller = new SimulatorMonitor(robots, e, strategyManager);
		
		robot3.setDestination(new Point(8, 3.5));
		robot1.setDestination(new Point(-8, 3.5));
		
		List<Point> point3 = new ArrayList<Point>();
		point3.add(new Point(3.5,3.5));
		point3.add(new Point(-3.5,3.5));
		point3.add(new Point(-8, 3.5));
		
		List<Point> point1 = new ArrayList<Point>();
		point1.add(new Point(-3.5,-3.5));
		point1.add(new Point(3.5, -3.5));
		point1.add(new Point(8, -3.5));
		
		List<Point> point2 = new ArrayList<Point>();
		point2.add(new Point(-3.5, 3.5));
		point2.add(new Point(-3.5, -3.5));
		point2.add(new Point(-8, -3.5));
		
		List<Point> point4 = new ArrayList<Point>();
		point4.add(new Point(3.5, -3.5));
		point4.add(new Point(3.5, 3.5));
		point4.add(new Point(8, 3.5));
		
		
		Mission mission3 = new Mission(point3, robot3);
		Mission mission1 = new Mission(point1, robot1);
		
		Mission mission2 = new Mission(point2, robot2);
		Mission mission4 = new Mission(point4, robot4);
		
		System.out.println(mission3.getRover().getName());
		
		Strategy strategy3 = new Strategy(mission3);
		//Strategy strategy1 = new Strategy(mission1);
		
		System.out.println(strategy3.getMission().getPoints());
		
		strategy3.addPointHistory(new Point(1,1));
		System.out.println(strategy3.getAllPoints());
		
		strategyManager.provideMission(mission3);
		strategyManager.provideMission(mission1);
		strategyManager.provideMission(mission2);
		strategyManager.provideMission(mission4);
		
		
	}
}
