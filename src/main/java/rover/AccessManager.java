package rover;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import project.AbstractRobotSimulator;

public class AccessManager {
	
	List<AreaController> listAreaController;
	
	public AccessManager(List<AreaController> listAreaController) {
		this.listAreaController = listAreaController;
	}
	
	//the returned area is not owned by the rover and the rover is inside this area
	public AreaController isInArea(AbstractRobotSimulator rover) {
		for (Iterator<AreaController> iter = listAreaController.iterator(); iter.hasNext(); ) {
			AreaController ac = iter.next();
			if(ac.isInArea(rover) && !ac.isTheOwner(rover)) {
				return ac;
			}
		}
		return null;
	}
	
	//Release area owed by a Rover if possible
	public void releaseArea(AbstractRobotSimulator rover){ 
		for (Iterator<AreaController> iter = listAreaController.iterator(); iter.hasNext(); ) {
			AreaController ac = iter.next();
			ac.release(rover);
		}
	}
	
	public void manageAccess(Rover rover) {
		
		releaseArea(rover);
		
		AreaController ac = isInArea(rover);
		if(ac != null) {	//if the rover is in an area
			if(!ac.tryAcquire(rover)) {	//if the rover cannot acces to the area
				if(!rover.isPaused()) {	//pause the rover if it is not already paused
					rover.pauseRover();
				}
			}
			else {						//if the rover can acces to the area
				if(rover.isPaused()) {	//allow the rover to move if it was paused
					rover.continueRover();
				}
			}
		}
	}
}
