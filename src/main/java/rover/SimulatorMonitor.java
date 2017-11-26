package rover;

import java.util.Set;

import project.AbstractSimulatorMonitor;
import simbad.sim.EnvironmentDescription;

public class SimulatorMonitor extends AbstractSimulatorMonitor<RobotAvatar> {
	
	private StrategyManager strategyManager;
	
	public SimulatorMonitor( Set<RobotAvatar> robots, EnvironmentDescription e, StrategyManager strategyManager) {
		super(robots, e);
		this.strategyManager = strategyManager;
	}

	@Override
	public void update ( RobotAvatar robot ) {
		System.out.println(robot.getPosition());
		if(robot.isAtPosition(robot.getDestination())) {
			strategyManager.achievedPoint(robot.getDestination(), robot);
		}
	}
}
