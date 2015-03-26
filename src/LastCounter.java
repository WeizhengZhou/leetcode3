/*
Count hits in last minute 
Implemented by circular array
*/
import java.util.Arrays;
import java.util.Random;
public class LastCounter {	
	private static int SIZE  = 6;//should be 60, use 6 for test
	private int[] A = null;
	private int index = 0;
	private long startTime = 0;
	private int lastMinuteCount = 0;
	public LastCounter(){
		this.A = new int[SIZE];
		this.index = 0;
		//Counter start time, index start from 0
		this.startTime = (long) (System.currentTimeMillis()/1E3);
		this.lastMinuteCount = 0;
	}
	public void hit(){
		int lastIndex = index;//record last index
		this.index = getIndex();//get current index
		if(lastIndex == index){//still in this slot
			A[index] += 1;//increase current second count by 1
			this.lastMinuteCount +=1;//increase last minute count
		}
	
		else{
			for(int i=(lastIndex+1)%SIZE;i<=this.index;i++){//[lastindex, index-1] has no hits
				this.lastMinuteCount -= A[i];//for index, i is 60 seconds ago
				A[i] = 0;
			}		
			A[this.index] = 1;//first hit in this second
			this.lastMinuteCount +=1;//update lastMinute 
		}
		int sum = 0;
		for(int i=0;i<A.length;i++) 
			sum += A[i];
		System.out.println("lastIndex = " + lastIndex + 
							", index = " + index  +
							", count = " + lastMinuteCount + 
							", A = " + Arrays.toString(A) + 
							", sum(A) = " + sum);	
	}
	public int lastMinuteCount(){
		return lastMinuteCount;
	}
	// Calculate the index in circular array based on the current time
	public int getIndex(){
		long curTime = (long) (System.currentTimeMillis()/1E3);
		int timeElipse = (int) (curTime - startTime); 
		System.out.println("timeElipse = "+ timeElipse + ", ");
		return (timeElipse % SIZE);
	}
	public static void main(String[] args){
		LastCounter solu = new LastCounter();
		Random rd = new Random();
		for(int i=0;i<1E3;i++){
			System.out.print("i = " + i + ", ");
			solu.hit();
			try {
				Thread.sleep(rd.nextInt(100));//thread sleep a random time between [0,100] miliseconds 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
}

