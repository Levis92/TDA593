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
		
		AreaController aC1 = new AreaController ( new Point(-3.5,3.5), 3.5 ,e);
		AreaController aC2 = new AreaController ( new Point(3.5,3.5), 3.5 ,e);
		AreaController aC3 = new AreaController ( new Point(-3.5,-3.5), 3.5 ,e);
		AreaController aC4 = new AreaController ( new Point(3.5,-3.5), 3.5 ,e);
		
		robot1.setDestination(new Point(-3.5, 3.5));
		
		StrategyManager sm = new StrategyManager();
		AbstractSimulatorMonitor<RobotAvatar> controller = new SimulatorMonitor(robots, e, sm);
		
		
		
		List<Point> p = new ArrayList<Point>();
		p.add(new Point(3.5,3.5));
		p.add(new Point(-3.5,3.5));
		p.add(new Point(-8, 3.5));
		Mission m = new Mission(p, robot1);
		System.out.println(m.getRover().getName());
		Strategy s = new Strategy(m);
		System.out.println(s.getMission().getPoints());
		s.addPointHistory(new Point(1,1));
		System.out.println(s.getAllPoints());
		sm.provideMission(m);
		
	}
}
