package additional;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class RunningMedium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunningMedium r=new RunningMedium();
		r.add(1);
		System.out.println(r.getMediam());
		r.add(2);
		System.out.println(r.getMediam());
		r.add(3);
		System.out.println(r.getMediam());
		r.add(3);
		System.out.println(r.getMediam());
	}
	
	private Queue<Integer> minHeap=new PriorityQueue<Integer>();
	private PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(100,new Comparator<Integer>(){

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2-o1;
		}});
	
	public void add(int x){
		double median=getMediam();
		if(minHeap.size()==maxHeap.size()){
			if(x<median)
			{
				maxHeap.add(x);
			}
			else{
				if(!minHeap.isEmpty())
				{
					maxHeap.add(minHeap.poll());
					minHeap.add(x);
				}
				else{
					maxHeap.add(x);
				}
			}
		}
		else if(minHeap.size()<maxHeap.size()){
			if(x>median)
			{
				minHeap.add(x);
			}
			else{
				
				minHeap.add(maxHeap.poll());
				maxHeap.add(x);
			}
		}
	}
	
	public double getMediam(){
		if(maxHeap.isEmpty()){
			return Integer.MAX_VALUE;
		}
		if(minHeap.size()==maxHeap.size()){
			return (minHeap.peek()+maxHeap.peek())/2.0;
		}
		else{
			return maxHeap.peek();
		}
	}

}
