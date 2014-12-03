package MultiThread;

public class MultiThreadTest {
	public static void main(String[] args){
		Runnable r = new MyRunnable();
		Thread t1 = new Thread(r);
		t1.start();
		Thread t2 = new Thread(r);
		t2.start();
	}
}
class MyRunnable implements Runnable{
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println("Thread ID = " + Thread.currentThread().getId() 
					+ ", i = " + i 
					+ ": I am running!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}
