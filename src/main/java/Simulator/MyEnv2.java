package Simulator;

import java.awt.Color;

import simbad.sim.AbstractWall;
import simbad.sim.Boundary;
import simbad.sim.EnvironmentDescription;
import simbad.sim.HorizontalBoundary;
import simbad.sim.HorizontalWall;
import simbad.sim.VerticalBoundary;
import simbad.sim.VerticalWall;

public class MyEnv2 extends EnvironmentDescription {
	public MyEnv2(){
		Color c1 = Color . GRAY ;
		Color c2 = Color . RED ;
		
		Boundary w1 = new HorizontalBoundary(-10.0f, -10.0f, 10.0f, this, c1);
		Boundary w2 = new HorizontalBoundary(10.0f, -10.0f, 10.0f, this, c1);
		Boundary w3 = new VerticalBoundary(10.0f, -10.0f, 10.0f, this, c1);
		Boundary w4 = new VerticalBoundary(-10.0f, -10.0f, 10.0f, this, c1);
		
		AbstractWall consultingRoomWall1 = new VerticalWall(-3.0f, -6.0f, -4.0f, this, c2);
		AbstractWall consultingRoomWall2 = new VerticalWall(-3.0f, -2.0f, 2.0f, this, c2);
		AbstractWall consultingRoomWall3 = new VerticalWall(-3.0f, 4.0f, 6.0f, this, c2);
		AbstractWall consultingRoomWall4 = new VerticalWall(3.0f, -6.0f, -4.0f, this, c2);
		AbstractWall consultingRoomWall5 = new VerticalWall(3.0f, -2.0f, 2.0f, this, c2);
		AbstractWall consultingRoomWall6 = new VerticalWall(3.0f, 4.0f, 6.0f, this, c2);
		AbstractWall consultingRoomWall7 = new HorizontalWall(-6.0f, -9.0f, 9.0f, this, c2);
		AbstractWall consultingRoomWall8 = new HorizontalWall(6.0f, -9.0f, 9.0f, this, c2);
		
		AbstractWall surgeryRoomWall1 = new HorizontalWall(0.0f, -3.0f, -9.0f, this, c2);
		AbstractWall surgeryRoomWall2 = new HorizontalWall(0.0f, 3.0f, 9.0f, this, c2);
		AbstractWall surgeryRoomWall3 = new VerticalWall(-9.0f, 6.0f, -6.0f, this, c2);
		AbstractWall surgeryRoomWall4 = new VerticalWall(9.0f, 6.0f, -6.0f, this, c2);

    }
}
