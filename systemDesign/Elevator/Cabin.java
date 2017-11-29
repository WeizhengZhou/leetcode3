import java.util.*;
public class Cabin {
	private boolean isRun;
	private int minFloor;
	private int maxFloor;
	private int id;
	private int curFloor;
	private boolean isMovingUp;
	private boolean isDoorOpen;
	private Set<Integer> destFloors = null;
	
	public Cabin(int id, int minFloor, int maxFloor){
		this.id = id;
		this.minFloor = minFloor;
		this.maxFloor = maxFloor;
		this.curFloor = 0;
		this.isMovingUp = false;
		this.isDoorOpen = false;
		this.destFloors = new HashSet<>();
	}
	public void moveUp(){
		if(isDoorOpen == true) return;
		if(curFloor < this.maxFloor)
			this.curFloor++;
	}
	public void moveDown(){
		if(isDoorOpen == true) return;
		if(curFloor > this.minFloor)
			this.curFloor--;
	}
	public void hold(){	
	}
	public void openDoor(){
		this.isDoorOpen = true;
	}
	public void closeDoor(){
		this.isDoorOpen = false;
	}
	public void addDestFloor(int floorNumber){
		this.destFloors.add(floorNumber);
	}
	public void run(){
		while(true){
			if(isRun == false){
				this.hold();
			}
			else if(isMovingUp){
				this.moveUp();
			}
			else{
				this.moveDown();
			}
			if(destFloors.contains(this.curFloor)){
				this.openDoor();
				this.closeDoor();
			}
		}	
	}
	public String toString(){
		return "id = " + this.id + ", floor = " + this.curFloor + ", isUp =" + isMovingUp; 
	}

}
