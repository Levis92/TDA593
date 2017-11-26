// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package rover;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import project.Point;
import rover.IMissionAchieved;
import rover.IPointAchieved;
import rover.IStrategyManager;
import rover.Mission;
import rover.Strategy;

/************************************************************/
/**
 * 
 */
public class StrategyManager implements IPointAchieved, IStrategyManager {
	/**
	 * 
	 */
	public List<Strategy> strategies;

	public StrategyManager() {
		this.strategies = new ArrayList<Strategy>();
	}
	
	/**
	 * 
	 * @param mission 
	 * @return 
	 */
	private Strategy initialiseStrategy(Mission mission){
		Strategy strategy = new Strategy(mission);
		this.strategies.add(strategy);
		return strategy;
	}


	/**
	 * 
	 * @param roverName 
	 * @return 
	 */
	private Point defineNextPoint(Strategy strategy) {
		for (Iterator<Point> iter = strategy.getMission().getPoints().iterator(); iter.hasNext(); ) {
			Point point = iter.next();
			if(!strategy.getAllPoints().contains(point)) {
				return point;	//Next point to reach
			}
		}
		return null; //No more points to reach
	}
	
	private Strategy findRoverStrategy(RobotAvatar rover){
		for (Iterator<Strategy> iter = this.strategies.iterator(); iter.hasNext(); ) {
			Strategy strategy = iter.next();
			if(strategy.getMission().getRover() == rover) {
				return strategy;
			}
		}
		return null;
	}
	

	/**
	 * 
	 * @param point 
	 * @param roverName 
	 * @return 
	 */
	private void providePointToRover(Point point, RobotAvatar rover){	
		rover.setDestination(point);
	}


	public boolean provideMission(Mission mission) {
			Strategy strategy = initialiseStrategy(mission);
			Point point = defineNextPoint(strategy);
			strategy.addPointHistory(point);
			providePointToRover(point, mission.getRover());
			return true;
	}

	public boolean pauseStrategy(Mission mission) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean continueStrategy(Mission mission) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean changeMission(Mission mission) {
		// TODO Auto-generated method stub
		return false;
	}

	public Strategy getStrategyPaused() {
		// TODO Auto-generated method stub
		return null;
	}

	public void achievedPoint(Point savepoint, RobotAvatar rover) {
		Strategy strategy = findRoverStrategy(rover);
		Point point = defineNextPoint(strategy);
		if(point == null) {
			System.out.println("mission succeded");
		}
		else {
			strategy.addPointHistory(point);
			providePointToRover(point, rover);
		}
	}
};
