
public class Singleton {
//	private static final Singleton INSTANCE = new Singleton();
//	private Singleton(){}
//	public static Singleton getInstance(){
//		return INSTANCE;
//	}
	
	public void printInfo(){
		System.out.println("This is a singleton");
	}	
	private static Singleton INSTANCE;
	private Singleton(){}
	public static Singleton getInstance(){
		if(INSTANCE == null){
			synchronized (Singleton.class){
				if(INSTANCE == null){
					INSTANCE = new Singleton();
				}
			}	
		}
		return INSTANCE;
	}
		
	public static void main(String[] args){
		Singleton s = Singleton.getInstance();
		s.printInfo();		
	}

}
