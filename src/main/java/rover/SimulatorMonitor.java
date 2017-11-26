package rover;

import java.util.Set;

import project.AbstractSimulatorMonitor;
import simbad.sim.EnvironmentDescription;

public class SimulatorMonitor extends AbstractSimulatorMonitor<RobotAvatar> {
	
	private StrategyManager sm;
	
	public SimulatorMonitor( Set<RobotAvatar> robots, EnvironmentDescription e, StrategyManager sm) {
		super(robots, e);
		this.sm = sm;
	}

	@Override
	public void update ( RobotAvatar robot ) {
		System.out.println(robot.getPosition());
		if(robot.isAtPosition(robot.getDestination())) {
			sm.achievedPoint(robot.getDestination(), robot);
		}
	}
}
