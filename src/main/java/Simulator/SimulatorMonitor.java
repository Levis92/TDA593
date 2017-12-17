package Simulator;

import java.util.Set;

import project.AbstractSimulatorMonitor;
import rover.Rover;
import simbad.sim.EnvironmentDescription;

public class SimulatorMonitor extends AbstractSimulatorMonitor<Rover> {
	
	public SimulatorMonitor( Set<Rover> robots, EnvironmentDescription e) {
		super(robots, e);
	}

	@Override
	public void update (Rover rover) {
		rover.routine();
	}
	
}
