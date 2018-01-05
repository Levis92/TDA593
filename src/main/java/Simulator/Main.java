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
import rover.Model.Mission;
import rover.Model.PhysicalArea;
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
		
		AccessController aC1 = new AccessController ( new Point(-3.5,0), 5.1 ,e);
		AccessController aC2 = new AccessController ( new Point(3.5,0), 5.1 ,e);
//		AccessController aC3 = new AccessController ( new Point(-8, 0), 3.5 ,e);
//		AccessController aC4 = new AccessController ( new Point(3.5,-3.5), 3.5 ,e);
		
		listAreaController.add(aC1);
		listAreaController.add(aC2);
//		listAreaController.add(aC3);
//		listAreaController.add(aC4);
		
		//Missions Initialization
		
		//Initialize operator //not fully implemented
		

		
		LinkedList<Point> point1 = new LinkedList<Point>();
		point1.add(new Point(3.5,3.5));
		point1.add(new Point(-3.5,3.5));
		point1.add(new Point(-8, 3.5));
		
		LinkedList<Point> point2 = new LinkedList<Point>();
		point2.add(new Point(-3.5, 3.5));
		point2.add(new Point(-3.5, -3.5));
		point2.add(new Point(-8, -3.5));
		
		LinkedList<Point> point3 = new LinkedList<Point>();
		point3.add(new Point(-3.5,-3.5));
		point3.add(new Point(3.5, -3.5));
		point3.add(new Point(8, -3.5));
		
		LinkedList<Point> point4 = new LinkedList<Point>();
		point4.add(new Point(3.5, -3.5));
		point4.add(new Point(3.5, 3.5));
		point4.add(new Point(8, 3.5));
		
		
		//need to figure out if List or arrays
		Mission mission1 = new Mission(point1);
		Mission mission2 = new Mission(point2);
		Mission mission3 = new Mission(point3);
		Mission mission4 = new Mission(point4);
		
		//Area Initialization
		List<AbstractArea> areas = new ArrayList<AbstractArea>(); 
		
		PhysicalArea area1 = new PhysicalArea(new Point(-7, 0), 7, 7, "Surgery", null, null); 
		PhysicalArea area2 = new PhysicalArea(new Point(0, 0), 7, 7, "Surgery", null, null);
		PhysicalArea area3 = new PhysicalArea(new Point(0, -7), 7, 7, "Surgery", null, null);
		PhysicalArea area4 = new PhysicalArea(new Point(-7, -7), 7, 7, "Surgery", null, null);
		
		
		areas.add(area1);
		areas.add(area2);
		areas.add(area3);
		areas.add(area4);
				
		//Strategy Initialization
		
		
		//AccessManager Initialization
		//need to figure out if List or arrays
		AccessManager accessManager = new AccessManager(listAreaController);
		
		//Rovers Initialization
		Set<Rover> robots = new HashSet<>();
		
		
		Rover robot1 = new Rover(new Point(8, 3.5), "Robot 1", accessManager, areas);
		Rover robot2 = new Rover(new Point(-8, 3.5), "Robot 2", accessManager, areas);
		Rover robot3 = new Rover(new Point(-8.1, -3.5), "Robot 3", accessManager, areas);
		Rover robot4 = new Rover(new Point(8.1, -3.5), "Robot 4",  accessManager, areas);
		
		robots.add(robot1);
		robots.add(robot2);
		robots.add(robot4);
		robots.add(robot3);
			
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
				
		//Simulator Initialization
		AbstractSimulatorMonitor<Rover> controller = new SimulatorMonitor(robots, e);
		
		//List with all the procedures
		IVisitorProcedure[] proc = new IVisitorProcedure[2];
        proc[0] = new ProcedureA(map);
        proc[1] = new ProcedureB(map);
        
        //Start the rewardpoints thread
        RewardPointsManager rpm = new RewardPointsManager(proc, map, technicalOperator);
        new Thread(rpm).start();
	}

}
