package Simulator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import project.AbstractSimulatorMonitor;
import project.Point;
import rover.Controller.AccessManager;
import rover.Controller.IStrategy;
import rover.Controller.IVisitorProcedure;
import rover.Controller.ProcedureA;
import rover.Controller.ProcedureB;
import rover.Controller.RewardPointsManager;
import rover.Model.AbstractArea;
import rover.Model.IRoverLocator;
import rover.Model.LogicalArea;
import rover.Model.Mission;
import rover.Model.PhysicalArea;
import rover.Model.Rover;
import rover.Controller.Strategy1;
import rover.Controller.StrategyFactory;


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
		
		//Area Initialization
		List<AbstractArea> areas = new ArrayList<AbstractArea>(); 
		
		PhysicalArea area1 = new PhysicalArea(new Point(-5,-2), 10, 4, "Consulting", null, null);
		areas.add(area1);
		
		//Strategy Initialization
		StrategyFactory strategyFactory = new StrategyFactory(); 
		
		//AccessManager Initialization
		AccessManager accessManager = new AccessManager(listAreaController);
		
		//Rovers Initialization
		Set<Rover> robots = new HashSet<>();
		
		Rover robot1 = new Rover(new Point(3, 8), "Robot 1", accessManager, areas);
		Rover robot2 = new Rover(new Point(3, -8), "Robot 2", accessManager, areas);
		Rover robot3 = new Rover(new Point(-3, 8), "Robot 3", accessManager, areas);
		Rover robot4 = new Rover(new Point(-3, -8), "Robot 4",  accessManager, areas);
		
		robots.add(robot1);
		robots.add(robot2);
		robots.add(robot3);
		robots.add(robot4);
		
		//Simulator Initialization
		AbstractSimulatorMonitor<Rover> controller = new SimulatorMonitor(robots, e);
		
		//Beginning of the mission 
		robot1.provideMission(mission1, strategyFactory.createStrategy(2));
		robot2.provideMission(mission2, strategyFactory.createStrategy(2));
		robot3.provideMission(mission3, strategyFactory.createStrategy(2));
		robot4.provideMission(mission4, strategyFactory.createStrategy(2));

		HashMap<IRoverLocator, Integer> map = new HashMap<IRoverLocator, Integer>();
		
		map.put(robot1, 0);
		map.put(robot2, 0);
		map.put(robot3, 0);
		map.put(robot4, 0);
		
		IVisitorProcedure[] proc = new IVisitorProcedure[2];
        proc[0] = new ProcedureA();
        proc[1] = new ProcedureB();
        
        RewardPointsManager rpm = new RewardPointsManager(proc, map);
        new Thread(rpm).start();
	}
}
