package se.chalmers.cse.mdsd1718.yakindu;

// This class implements an array of Area Controllers.
// Trying to acquire access to area covered by controller
// 0 is done by calling tryAcquire(0). Releasing access
// to that area is done by calling release(0), etc.
// The code performs no error checking.
public class Assignment4Rooms {

	// Increast this constant if you need more controllers.
	private boolean locked[] = new boolean[10];
	
	public boolean tryAcquire(long n) {
		int m = (int) n;
		if (locked[m]) {
			return false;
		} else {
			locked[m] = true;
			return true;
		}
	}

	public void release(long n) {
		int m = (int) n;
		locked[m] = false;
	}
}
