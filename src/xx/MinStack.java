package xx;

public class MinStack {
	Stack<Integer> s=new Stack<Integer>();
	Stack<Integer> minS=new Stack<Integer>();
	
	public void push(int x){
		s.push(x);
		if(minS.isEmpty()||x<=minS.peek())minS.push(x);
	}
	
	public void pop(){
	    int x=s.pop();
	    if(x==minS.peek())minS.pop();
	}
	
	public int top(){
	    return s.peek();
		
	}
	
	public int getMin(){
	    return minS.peek();
	}
}
