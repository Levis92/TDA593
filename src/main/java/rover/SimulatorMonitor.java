package rover;

import java.util.Set;

import project.AbstractSimulatorMonitor;
import simbad.sim.EnvironmentDescription;

public class SimulatorMonitor extends AbstractSimulatorMonitor<Rover> {
	
	
	public SimulatorMonitor( Set<Rover> robots, EnvironmentDescription e) {
		super(robots, e);
	}

	@Override
	public void update (Rover robot) {
		System.out.println(robot.getPosition());
		if(robot.isWorking()) {
			if(robot.isAtPosition(robot.getDestination()) && !robot.isPaused()) {
				robot.goToNextPoint();
			}
		}
	}
}
