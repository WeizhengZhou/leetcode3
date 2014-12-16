package additional;

import java.util.Stack;

public class MinQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinQueue m=new MinQueue();
		m.add(1);
		System.out.println("min="+m.getMin());//1
		m.add(2);
		System.out.println("min="+m.getMin());//2
		m.add(3);
		System.out.println("min="+m.getMin());//3
		//m.add(0);
		System.out.println("min="+m.getMin());//1
		System.out.println("remove="+m.remove());//1
		System.out.println("min="+m.getMin());//2
		System.out.println("remove="+m.remove());//2
		System.out.println("min="+m.getMin());//3
		System.out.println("remove="+m.remove());//3
		System.out.println("min="+m.getMin());//MAX
		//System.out.println("remove="+m.remove());//0
		//System.out.println("min="+m.getMin());//Max

	}
	
	private class Pair{
		int val;
		int min;
		public Pair(int x, int y){
			val=x;
			min=y;
		}
	}
	
	Stack<Pair> first=new Stack<Pair>();
	Stack<Pair> second=new Stack<Pair>();
	
	public void add(int x){
		if (first.isEmpty()){
			first.push(new Pair(x,x));
		}
		else{
			Pair top=first.peek();
			int min=Math.min(top.min, x);
			first.push(new Pair(x,min));
		}
	}
	
	public int remove(){
		if(!second.isEmpty()){
			Pair pop=second.pop();
			return pop.val;
		}
		else{
			if(first.isEmpty()){
				return -1;
			}
			while(!first.isEmpty()){
				Pair f=first.pop();
				int min=f.val;
				if(!second.isEmpty()){
					Pair top=second.peek();
					min=Math.min(top.min, min);
				}
				second.push(new Pair(f.val,min));
			}
			Pair pop=second.pop();
			return pop.val;
		}
	}
	
	public int getMin(){
		int min=Integer.MAX_VALUE;
		if(!second.isEmpty()){
			Pair top=second.peek();
			min=Math.min(min, top.min);
		}
		if(!first.isEmpty()){
			Pair top=first.peek();
			min=Math.min(min, top.min);
		}
		return min;
	}
}
