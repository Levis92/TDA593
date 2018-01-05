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
import rover.Controller.IMissionManager;
import rover.Controller.IStrategy;
import rover.Controller.IVisitorProcedure;
import rover.Controller.MissionManager;
import rover.Controller.ProcedureA;
import rover.Controller.ProcedureB;
import rover.Controller.RewardPointsManager;
import rover.Model.AbstractArea;
import rover.Model.IRoverLocator;
import rover.Model.LogicalArea;
import rover.Model.Mission;
import rover.Model.PhysicalArea;
import rover.Model.Rover;
import rover.View.Operator;
import rover.View.OperatorFactory;
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
		
		PhysicalArea area1 = new PhysicalArea(new Point(-6, -3), 12, 6, "Consulting", null, null); 
		PhysicalArea area2 = new PhysicalArea(new Point(0, 3.1), 6, 5.9, "Surgery", null, null);
		PhysicalArea area3 = new PhysicalArea(new Point(0, -9), 6, 5.8, "Surgery", null, null);
		PhysicalArea area4 = new PhysicalArea(new Point(-6, 3.1), 6, 5.8, "Surgery", null, null);
		PhysicalArea area5 = new PhysicalArea(new Point(-6, -9), 6, 5.8, "Surgery", null, null);
		
		areas.add(area1);
		areas.add(area2);
		areas.add(area3);
		areas.add(area4);
		areas.add(area5);
		
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
		
		IMissionManager missionManager = new MissionManager(robots);

		OperatorFactory operatorFactory = new OperatorFactory();
		Operator technicalOperator = operatorFactory.getTechnicalOperatorInstance(missionManager);
		
		//Beginning of the mission 
		
		technicalOperator.getMissionManagerView().createMission(point1, robot1, 2);
		technicalOperator.getMissionManagerView().createMission(point2, robot2, 2);
		technicalOperator.getMissionManagerView().createMission(point3, robot3, 2);
		technicalOperator.getMissionManagerView().createMission(point4, robot4, 2);
		
		//Map storing rovers and their rewardpoints
		HashMap<IRoverLocator, Integer> map = new HashMap<IRoverLocator, Integer>();
		
		//Add all rovers to the map with zero points
		map.put(robot1, 0);
		map.put(robot2, 0);
		map.put(robot3, 0);
		map.put(robot4, 0);
		
		//List with all the procedures
		IVisitorProcedure[] proc = new IVisitorProcedure[2];
        proc[0] = new ProcedureA(map);
        proc[1] = new ProcedureB(map);
        
        //Start the rewardpoints thread
        RewardPointsManager rpm = new RewardPointsManager(proc, map, technicalOperator);
        new Thread(rpm).start();
        
	}
}
