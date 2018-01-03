// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package rover.Model;

import java.util.ArrayList;
import java.util.List;
import project.Point;
import rover.Controller.IVisitorProcedure;
import rover.Model.AbstractArea;
import rover.Model.LogicalArea;

/************************************************************/
/**
 * 
 */
public class PhysicalArea extends AbstractArea {
	/**
	 * 
	 */
	private List<PhysicalArea> nestedPhysicalAreasList;
	/**
	 * 
	 */
	private List<LogicalArea> nestedLogicalAreasList;

	
	/**
	 * 
	 * @param position 
	 * @param width 
	 * @param height 
	 * @param areaType 
	 * @param nestedLogicalArea 
	 * @param nestedPhysicalAreas 
	 */
	public PhysicalArea(Point position, double width, double height, String areaType,
			LogicalArea nestedLogicalArea, PhysicalArea nestedPhysicalArea) {
		super(position, width, height, areaType);
		
		nestedPhysicalAreasList= new ArrayList<PhysicalArea>();
		nestedLogicalAreasList = new ArrayList<LogicalArea>();
		
		nestedPhysicalAreasList.add(nestedPhysicalArea);
		nestedLogicalAreasList.add(nestedLogicalArea);
	}
	//TODO implement contains, do we need contains though?
	/**
	 * 
	 * @param point 
	 * @return 
	 */
	public boolean contains(Point point) {
		return true;
	}

	/**
	 * 
	 * @return 
	 */
	public String getAreaType() {
		return super.getAreaType();
	}

	@Override
	public boolean isInArea(Point point) {
		
		boolean isInArea;
		Point position = super.getPosition();
		double areaWidth =super.getWidth();
		double areaHeight = super.getHeight();
		if(position.getX() > point.getX() || position.getZ() > point.getZ() ||
				position.getX() + areaWidth < point.getX() || position.getZ() + areaHeight < point.getZ()) {
			isInArea = false;
		}else {
			isInArea = true;
		}
		return isInArea;
	}

	
	@Override
	public Point getPosition() {
		return super.getPosition();
	}

	@Override
	public double getWidth() {
		return super.getWidth();
	}

	@Override
	public double getHeight() {
		return super.getHeight();
	}
	@Override
	public void accept(IVisitorProcedure procedure, IRoverLocator rover) {
		procedure.visit(this, rover);
		
	}
};
