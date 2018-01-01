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
public class ProcedureA implements IVisitorProcedure {
	/**
	 * 
	 */
	public Map<IRoverLocator, Integer> rewardPoints;

	/**
	 * 
	 * @param physicalArea 
	 * @param rover 
	 * @return 
	 */
	public void visit(PhysicalArea physicalArea, IRoverLocator rover) {
		int newPoint;
		String areaType = physicalArea.getAreaType();
		
		if (areaType.equals("Consulting")) newPoint = 10;
		else if (areaType.equals("Surgery")) newPoint = 20;
		else return;
		
		rewardPoints.put(rover, rewardPoints.get(rover) + newPoint);
		System.out.println("New value" + rewardPoints.get(rover));
	}

	/**
	 * Procedure A should not consider logical areas
	 * @param logicalArea 
	 * @param rover 
	 * @return 
	 */
	public void visit(LogicalArea logicalArea, IRoverLocator rover) {
		return; 
	}
	
};
