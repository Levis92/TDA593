// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package rover.Controller;

import java.util.Iterator;

import rover.Controller.IStrategy;
import rover.Model.Rover;

/************************************************************/
/**
 * 
 */
public class Strategy1 implements IStrategy {
	
	/**
	 * 
	 * @param rover 
	 */
	public void applyBehaviour(Rover rover) {
		//System.out.println(rover.getPosition());
		if(!rover.isSleeping()) { // the rover has a mission to perform
			if(rover.isAtPosition(rover.getDestination()) && !rover.isPaused()) {
				rover.goToNextPoint();
			}
			if(!rover.isPaused()) {
				for (Iterator<INotifyOperator> iter = rover.getOperators().iterator(); iter.hasNext(); ) {
					INotifyOperator operator = iter.next();
					operator.notifyLocation(rover, rover.getPosition());
				}
			}
			rover.getAccessManager().manageAccess(rover);
		}
	}
};

