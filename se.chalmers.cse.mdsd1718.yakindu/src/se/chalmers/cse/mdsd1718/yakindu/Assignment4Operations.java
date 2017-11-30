package se.chalmers.cse.mdsd1718.yakindu;

public class Assignment4Operations {
	private long counter;
	private boolean toggled = false;
	
	
	public void increaseCounter() {
		if (toggled) {
			return;
		}
		counter = (counter % 5) + 1;	
	}
	
	public long getCounter() {
		return counter;
	}
	
	public void toggleCounter() {
		toggled = !toggled;
	}
	
	public boolean isToggled() {
		return toggled;
	}
}
