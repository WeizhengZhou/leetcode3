package additional_wz;

public class Factory {
	interface Shape{
		void draw();
	}
	class Cycle implements Shape{
		@Override
		public void draw(){
			System.out.println("Draw a Cycle");
		}
	} 
	class Rectangle implements Shape{
		@Override
		public void draw(){
			System.out.println("Draw a Rectangle");
		}
	}
	public Shape getShape(String name){
		if(name == null)
			return null;
		else if(name.equalsIgnoreCase("Cycle"))
			return new Cycle();
		else if(name.equalsIgnoreCase("Rectangle"))
			return new Rectangle();
		else 
			return null;
	}
	public static void main(String[] args){
		Factory factory = new Factory();
		Shape s1 = factory.getShape("Cycle");
		Shape s2 = factory.getShape("Rectangle");
		s1.draw();
		s2.draw();
		
	}
}
