package Simulator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import project.AbstractSimulatorMonitor;
import project.Point;
import rover.Controller.AccessManager;
import rover.Controller.IStrategy;
import rover.Model.Mission;
import rover.Model.Rover;
import rover.Controller.Strategy1;
import rover.Controller.StrategyFactory;
import rover.View.Operator;
import rover.View.OperatorFactory;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		MyEnv e = new MyEnv();
		
		//AreaController Initialization
		List<AccessController> listAreaController = new ArrayList<AccessController>();
		
		AccessController aC1 = new AccessController ( new Point(-3.5,3.5), 3.5 ,e);
		AccessController aC2 = new AccessController ( new Point(3.5,3.5), 3.5 ,e);
		AccessController aC3 = new AccessController ( new Point(-3.5,-3.5), 3.5 ,e);
		AccessController aC4 = new AccessController ( new Point(3.5,-3.5), 3.5 ,e);
		
		listAreaController.add(aC1);
		listAreaController.add(aC2);
		listAreaController.add(aC3);
		listAreaController.add(aC4);
		
		//Missions Initialization
		
		//Initialize operator //not fully implemented
		/*
		OperatorFactory operatorFactory = new OperatorFactory();
		Operator operator = operatorFactory.getTechnicalOperatorInstance();
		*/
		
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
		
		
		//need to figure out if List or arrays
		Mission mission1 = new Mission(point1);
		Mission mission2 = new Mission(point2);
		Mission mission3 = new Mission(point3);
		Mission mission4 = new Mission(point4);
		
		//Strategy Initialization
		StrategyFactory strategyFactory = new StrategyFactory();
		IStrategy strategy = strategyFactory.createStrategy(1); 
		
		//AccessManager Initialization
		//need to figure out if List or arrays
		AccessManager accessManager = new AccessManager(listAreaController);
		
		//Rovers Initialization
		Set<Rover> robots = new HashSet<>();
		
		Rover robot1 = new Rover(new Point(-8, -3.5), "Robot 1", accessManager, null);
		Rover robot2 = new Rover(new Point(-8, 3.5), "Robot 2", accessManager, null);
		Rover robot3 = new Rover(new Point(8, 3.5), "Robot 3", accessManager, null);
		Rover robot4 = new Rover(new Point(8, -3.5), "Robot 4",  accessManager, null);
		
		robots.add(robot1);
		robots.add(robot2);
		robots.add(robot3);
		robots.add(robot4);
		


		
		//Simulator Initialization
		AbstractSimulatorMonitor<Rover> controller = new SimulatorMonitor(robots, e);
		
		//Beginning of the mission 
		/*
		operator.iOperatorCreateMissionview.createMission(point1, robot1);
		operator.iOperatorCreateMissionview.createMission(point2, robot2);
		operator.iOperatorCreateMissionview.createMission(point3, robot3);
		operator.iOperatorCreateMissionview.createMission(point4, robot4);
		*/
		
		robot1.provideMission(mission1, strategy);
		robot2.provideMission(mission2, strategy);
		robot3.provideMission(mission3, strategy);
		robot4.provideMission(mission4, strategy);
		

	}

}
