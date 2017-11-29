
public class Request {
	private int destFloor;
	private boolean isUp;
	public Request(int destFloor){
		this.destFloor = destFloor;
	}
	public int getRequestFloor() {
		return destFloor;
	}
	public boolean isUp() {
		return isUp;
	}
}
