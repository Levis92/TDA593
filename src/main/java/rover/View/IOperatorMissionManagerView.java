// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package rover.View;

import java.util.List;
import rover.Controller.IMissionManager;
import rover.Controller.IStrategy;
import rover.Model.Rover;
import project.Point;

/************************************************************/
/**
 * 
 */
public interface IOperatorMissionManagerView {

	/**
	 * 
	 * @param rover 
	 * @return 
	 */
	public boolean removeMission(Rover rover);

	/**
	 * 
	 * @return 
	 */
	public boolean removeAllMissions();

	/**
	 * 
	 * @return 
	 * @param rover 
	 */
	public boolean pauseMission(Rover rover);

	/**
	 * 
	 * @param rover 
	 * @return 
	 */
	public boolean continueMission(Rover rover);

	/**
	 * 
	 * @return 
	 */
	public boolean pauseAllMissions();

	/**
	 * 
	 * @return 
	 */
	public boolean continueAllMissions();

	/**
	 * 
	 * @param rover 
	 * @param strategy 
	 */
	public void changeStrategy(Rover rover, IStrategy strategy);

	/**
	 * 
	 * @param points 
	 * @param rover 
	 * @return 
	 * @param missionManager 
	 * @param strategy 
	 */
	public boolean createMission(List<Point> points, Rover rover, IMissionManager missionManager, IStrategy strategy);
};