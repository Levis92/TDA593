// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package rover.Controller;

import project.Point;
import rover.Model.Rover;

/************************************************************/
/**
 * 
 */
public interface IMissionManager {
	/**
	 * 
	 * @param points 
	 * @return 
	 * @param rover 
	 */
	public boolean createMission(Point[] points, Rover rover);

	/**
	 * 
	 * @param mission 
	 * @return 
	 */
	public boolean removeMission(undefined mission);

	/**
	 * 
	 * @return 
	 */
	public boolean removeAllMissions();

	/**
	 * 
	 * @param mission 
	 * @return 
	 */
	public boolean pauseMission(undefined mission);

	/**
	 * 
	 * @param mission 
	 * @return 
	 */
	public boolean continueMission(undefined mission);

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
};