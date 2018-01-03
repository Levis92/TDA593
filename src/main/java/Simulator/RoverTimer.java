package Simulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rover.Model.Rover;

public class RoverTimer implements ActionListener {
	private Rover rover;
	
	public RoverTimer(Rover rover) {
		this.rover = rover;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.rover.continueRover();
	}

}
