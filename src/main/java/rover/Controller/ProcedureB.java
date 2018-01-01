// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package rover.Controller;

import java.util.Map;
import rover.Controller.IVisitorProcedure;
import rover.Model.LogicalArea;
import rover.Model.PhysicalArea;
import rover.Model.IRoverLocator;

/************************************************************/
/**
 * 
 */
public class ProcedureB implements IVisitorProcedure {
	/**
	 * 
	 */
	public Map<IRoverLocator, Integer> rewardPoints;

	/**
	 * Procedure B should not consider physical areas
	 * @param physicalArea 
	 * @param rover 
	 * @return 
	 */
	public void visit(PhysicalArea physicalArea, IRoverLocator rover) {
		return;
	}

	/**
	 * 
	 * @param logicalArea 
	 * @param rover 
	 * @return 
	 */
	public void visit(LogicalArea logicalArea, IRoverLocator rover) {
		int newPoint;
		String areaType = logicalArea.getAreaType();
		
		if (areaType.equals("Wifi")) newPoint = 10;
		else if (areaType.equals("Eating")) newPoint = 20;
		else return;
		
		rewardPoints.put(rover, rewardPoints.get(rover) + newPoint);
		System.out.println("New value" + rewardPoints.get(rover));
	}

};
