package additional;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UglyNumber u=new UglyNumber();
		u.getUglyNum(11);
	}

	public int getUglyNum(int N){
		if(N==1){
			return 1;
		}
		List<Integer> base2=new LinkedList<Integer>();
		List<Integer> base3=new LinkedList<Integer>();
		List<Integer> base5=new LinkedList<Integer>();
		//base2.add(2);
		//base3.add(3);
		//base5.add(5);
		Queue<Integer> q=new PriorityQueue<Integer>();
		q.add(2);
		q.add(3);
		q.add(5);
		int r=0;
		for(int i=0;i<N-1;i++){
			r=q.poll();
			System.out.println(""+r);
			if(r%5==0){
				base5.add(r*5);
				q.add(base5.remove(0));
			}
			else if(r%3==0){
				base3.add(r*3);
				base5.add(r*5);
				q.add(base3.remove(0));
			}
			else {
				base2.add(r*2);
				base3.add(r*3);
				base5.add(r*5);
				q.add(base2.remove(0));
			}
		}
		return r;
	}
}
