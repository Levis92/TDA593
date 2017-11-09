package rover;

import project.AbstractRobot;
import project.SimulatorController;
import simbad.sim.EnvironmentDescription;

import java.util.Set;

public class Controller extends SimulatorController {

    public Controller(Set<? extends AbstractRobot> robots, EnvironmentDescription e) {
        super(robots, e);
    }

    @Override
    public void update() {
    }
}
