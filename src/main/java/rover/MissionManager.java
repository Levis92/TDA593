// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package rover;

import java.util.ArrayList;
import java.util.List;
import rover.IMissionAchieved;
import rover.IMissionManager;
import rover.IStrategyManager;
import rover.Mission;

/************************************************************/
/**
 * 
 */
public class MissionManager implements IMissionAchieved, IMissionManager {
	/**
	 * 
	 */
	public List<Mission> missions = new ArrayList<Mission>();

	/**
	 * 
	 * @return 
	 */
	public void achievedMission() {
	}

	/**
	 * 
	 * @return 
	 */
	public void achievedPoint() {
	}

	public boolean createMission(Mission mission) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeMission(Mission mission) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAllMissions() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean pauseMission(Mission mission) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean continueMission(Mission mission) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean pauseAllMissions() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean continueAllMissions() {
		// TODO Auto-generated method stub
		return false;
	}
};
