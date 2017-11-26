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
		RobotAvatar robot1 = new RobotAvatar(new Point(8, 3.5), "Robot 1");
		RobotAvatar robot2 = new RobotAvatar(new Point(-8, 3.5), "Robot 2");
		RobotAvatar robot3 = new RobotAvatar(new Point(-8, -3.5), "Robot 3");
		RobotAvatar robot4 = new RobotAvatar(new Point(8, -3.5), "Robot 4");
		
		robots.add(robot1);
//		robots.add(robot2);
//		robots.add(robot3);
//		robots.add(robot4);
		
		LocationController cP1 = new LocationController ( new Point(-3.5,3.5), 3.5 ,e);
		LocationController cP2 = new LocationController ( new Point(3.5,3.5), 3.5 ,e);
		LocationController cP3 = new LocationController ( new Point(-3.5,-3.5), 3.5 ,e);
		LocationController cP4 = new LocationController ( new Point(3.5,-3.5), 3.5 ,e);
		
		robot1.setDestination(new Point(-3.5, 3.5));
		
		StrategyManager strategyManager = new StrategyManager();
		AbstractSimulatorMonitor<RobotAvatar> controller = new SimulatorMonitor(robots, e, strategyManager);
		
		
		
		List<Point> point = new ArrayList<Point>();
		point.add(new Point(3.5,3.5));
		point.add(new Point(-3.5,3.5));
		point.add(new Point(-8, 3.5));
		Mission mission = new Mission(point, robot1);
		System.out.println(mission.getRover().getName());
		Strategy strategy = new Strategy(mission);
		System.out.println(strategy.getMission().getPoints());
		strategy.addPointHistory(new Point(1,1));
		System.out.println(strategy.getAllPoints());
		strategyManager.provideMission(mission);
		
	}
}
