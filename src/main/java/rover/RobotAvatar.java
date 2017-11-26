package rover;

import project.AbstractRobotSimulator;
import project.Point;

public class RobotAvatar extends AbstractRobotSimulator {

	private Point destination;
	
	public RobotAvatar(Point position, String name) {
		super(position, name);
	}
	
	public void setDestination(Point destination) {
		if (destination == null) {
			throw new NullPointerException("The destination cannot be null");
		}
		getAgent().setDestination(destination);
		this.destination = destination;
	}
	
	public Point getDestination() {
		return destination;
	}

}
