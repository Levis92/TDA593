package Simulator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import project.AbstractSimulatorMonitor;
import project.Point;
import rover.AccessController;
import rover.AccessManager;
import rover.IStrategy;
import rover.Mission;
import rover.Rover;
import rover.Strategy1;

public class Main2 {
public static void main(String[] args) throws InterruptedException {
		
		MyEnv2 e = new MyEnv2();
		
		//AreaController Initialization
		List<AccessController> listAreaController = new ArrayList<AccessController>();
		
		AccessController SC1 = new AccessController ( new Point(3,6), 3 ,e);
		AccessController SC2 = new AccessController ( new Point(3,-6), 3 ,e);
		AccessController SC3 = new AccessController ( new Point(-3,6), 3 ,e);
		AccessController SC4 = new AccessController ( new Point(-3,-6), 3 ,e);
		AccessController CC1 = new AccessController ( new Point(0,0), 4.5 ,e);
		
		listAreaController.add(SC1);
		listAreaController.add(SC2);
		listAreaController.add(SC3);
		listAreaController.add(SC4);
		listAreaController.add(CC1);
		
		//Missions Initialization
		LinkedList<Point> point1 = new LinkedList<Point>();
		point1.add(new Point(3,0));
		point1.add(new Point(3, 8));
		
		LinkedList<Point> point2 = new LinkedList<Point>();
		point2.add(new Point(3, 0));
		point2.add(new Point(3, -8));
		
		LinkedList<Point> point3 = new LinkedList<Point>();
		point3.add(new Point(-3,0));
		point3.add(new Point(-3,8));
		
		LinkedList<Point> point4 = new LinkedList<Point>();
		point4.add(new Point(-3, 0));
		point4.add(new Point(-3, -8));
		
		Mission mission1 = new Mission(point1);
		Mission mission2 = new Mission(point2);
		Mission mission3 = new Mission(point3);
		Mission mission4 = new Mission(point4);
		
		//Strategy Initialization
		IStrategy strategy = new Strategy1(); 
		
		//AccessManager Initialization
		AccessManager accessManager = new AccessManager(listAreaController);
		
		//Rovers Initialization
		Set<Rover> robots = new HashSet<>();
		
		Rover robot1 = new Rover(new Point(3, 8), "Robot 1", accessManager, null);
		Rover robot2 = new Rover(new Point(3, -8), "Robot 2", accessManager, null);
		Rover robot3 = new Rover(new Point(-3, 8), "Robot 3", accessManager, null);
		Rover robot4 = new Rover(new Point(-3, -8), "Robot 4",  accessManager, null);
		
		robots.add(robot1);
		robots.add(robot2);
		robots.add(robot3);
		robots.add(robot4);
		
		//Simulator Initialization
		AbstractSimulatorMonitor<Rover> controller = new SimulatorMonitor(robots, e);
		
		//Beginning of the mission 
		robot1.provideMission(mission1, strategy);
		robot2.provideMission(mission2, strategy);
		robot3.provideMission(mission3, strategy);
//		robot4.provideMission(mission4, strategy);


	}
}
