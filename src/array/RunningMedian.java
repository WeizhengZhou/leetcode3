package array;
import java.util.*;
public class RunningMedian {
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(100,Collections.reverseOrder());
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();	
	public void add(int e){
		if(maxHeap.size() == 0 && minHeap.size() == 0)
			maxHeap.add(e);
		else if(maxHeap.size() == 0 || minHeap.size() == 0){
			int min = Math.min(maxHeap.peek(), e);//add smaller one to maxHeap
			if(min == e){
				minHeap.add(maxHeap.remove());
				maxHeap.add(e);
			}
			else{
				minHeap.add(e);
			}
		}	
		else if(e < maxHeap.peek()){
			maxHeap.add(e);
		}
		else 
			minHeap.add(e);
		//balance between two heaps
		if(maxHeap.size() > minHeap.size()+1){
			minHeap.add(maxHeap.remove());
		}
		if(minHeap.size() > maxHeap.size()+1){
			maxHeap.add(minHeap.remove());
		}
	}
	
	public double getMedian(){
		if(maxHeap.size() == 0 && minHeap.size()==0)//no medians
			return -1;
		else if(maxHeap.size() == 0){//only one element
			return minHeap.peek();
		}
		else if(minHeap.size() == 0){//only one element
			return maxHeap.size();
		}
		else if(maxHeap.size() == minHeap.size()){//balanced, return effective median
			return (maxHeap.peek()+minHeap.peek())/2;
		}
		else{
			return (maxHeap.size()>minHeap.size())?maxHeap.peek():minHeap.peek();//one heap has one more elemetn
		}		
	}
	
	public static void main(String[] args){
		RunningMedian solu = new RunningMedian();
		int[] A = {1,3,2,4,5,9,8,5,6};
		for(int i=0;i<A.length;i++){
			solu.add(A[i]);
			System.out.println("i = " + i + ", median = " + solu.getMedian());
		}		
	}
}
