package rover;

import java.util.Set;

import project.AbstractSimulatorMonitor;
import simbad.sim.EnvironmentDescription;

public class SimulatorMonitor extends AbstractSimulatorMonitor<Rover> {
	
	AccessManager accessManager;
	
	public SimulatorMonitor( Set<Rover> robots, EnvironmentDescription e, AccessManager accessManager) {
		super(robots, e);
		this.accessManager = accessManager;
	}

	@Override
	public void update (Rover robot) {
		System.out.println(robot.getPosition());
		if(robot.isWorking()) { // the rover has a mission to perform
			if(robot.isAtPosition(robot.getDestination()) && !robot.isPaused()) {
				robot.goToNextPoint();
			}
			accessManager.manageAccess(robot);
		}
	}
}
