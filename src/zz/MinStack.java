//zz reviewed
package zz;

import java.util.Stack;

public class MinStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Stack<Integer> s=new Stack<Integer>();
	Stack<Integer> minS=new Stack<Integer>();
	
	public void push(int x){
		s.push(x);
		//zz
		//if(minS.isEmpth() == true || x<= minS.peek()){
		//	minS.push(x);
		//}
		if(!minS.isEmpty() && x<=minS.peek()){//zz did you considered why x>= peek, not x>peek
			minS.push(x);
		}
		if(minS.isEmpty()){
			minS.push(x);
		}
	}
	//zz when call pop, peek, make sure stack is not empty
	public void pop(){
		int x=s.pop();
		if(x==minS.peek()){
			minS.pop();
		}
	}
	
	public int top(){
		//zz should check s is empty or not before peek()
		return s.peek();
		
	}
	
	public int getMin(){
		return minS.peek();
	}

}
