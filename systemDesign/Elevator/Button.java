
public abstract class Button {
	private boolean isLightOn = false;
	public void setLightOn(){
		this.isLightOn = true;
	}
	public void setLightOff(){
		this.isLightOn = false;
	}
	public abstract void push();
}
class CabinButton extends Button {
	private Cabin cabin = null;
	private int levelNumber;
	public CabinButton(Cabin cabin, int levelNumber){
		this.cabin = cabin;
		this.levelNumber = levelNumber;
	}
	public int getLevelNumber() {
		return levelNumber;
	}
	@Override
	public void push() {
		cabin.addDestFloor(levelNumber);
	}
}
class LevelButton extends Button {
	private int levelNumber;
	private boolean isUp;
	public LevelButton(boolean isUp, int levelNumber){
		this.isUp = isUp;
		this.levelNumber = levelNumber;
	}
	public boolean isUp() {
		return isUp;
	}
	@Override
	public void push() {
		Request request = new Request(this.levelNumber);
		Controller.getInstance().addRequest(request);		
	}
}
