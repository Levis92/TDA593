package rover;

import java.awt.Color;
import simbad.sim.*;

public class MyEnv extends EnvironmentDescription {
	public MyEnv(){
		Color c1 = Color . GRAY ;
		Color c2 = Color . RED ;
		Boundary w1 = new HorizontalBoundary(-12.0f, -12.0f, 12.0f, this, c1);
		
		Boundary w2 = new HorizontalBoundary(12.0f, -12.0f, 12.0f, this, c1);
		
		Boundary w3 = new VerticalBoundary(12.0f, -12.0f, 12.0f, this, c1);
		
		Boundary w4 = new VerticalBoundary(-12.0f, -12.0f, 12.0f, this, c1);
		
		AbstractWall roomWall1 = new VerticalWall(7.0f, -7.0f, 7.0f, this, c2);
		
		AbstractWall roomWall2 = new VerticalWall(-7.0f, -7.0f, 7.0f, this, c2);
		
		AbstractWall roomWall3 = new HorizontalWall(0.0f, -7.0f, -4.5f, this, c2);
		
		AbstractWall roomWall4 = new HorizontalWall(-7.0f, -7.0f, -4.5f, this, c2);
		
		AbstractWall roomWall5 = new HorizontalWall(7.0f, -7.0f, -4.5f, this, c2);
		
		AbstractWall roomWall6 = new HorizontalWall(0.0f, 7.0f, 4.5f, this, c2);
		
		AbstractWall roomWall7 = new HorizontalWall(-7.0f, 7.0f, 4.5f, this, c2);
		
		AbstractWall roomWall8 = new HorizontalWall(7.0f, 7.0f, 4.5f, this, c2);
		
		AbstractWall roomWall9 = new HorizontalWall(7.0f, -2.5f, 2.5f, this, c2);
		
		AbstractWall roomWall10 = new HorizontalWall(0.0f, -2.5f, 2.5f, this, c2);
		
		AbstractWall roomWall11 = new HorizontalWall(-7.0f, -2.5f, 2.5f, this, c2);
		
		AbstractWall roomWall12 = new VerticalWall(0.0f, -2.5f, 2.5f, this, c2);
		
		AbstractWall roomWall13 = new VerticalWall(0.0f, -7.0f, -4.5f, this, c2);
		
		AbstractWall roomWall14 = new VerticalWall(0.0f, 7.0f, 4.5f, this, c2);

    }
}