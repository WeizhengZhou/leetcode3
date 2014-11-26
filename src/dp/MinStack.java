package dp;

import java.util.Stack;

public class MinStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	Stack<Integer> stack=new Stack<Integer>();
	Stack<Integer> min=new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        if(min.isEmpty()){
        	min.push(x);
        }
        else{
        	if(x<=min.peek()){
        		min.push(x);
        	}
        }
    }

    public void pop() {
        int p=stack.pop();
        if(p==min.peek()){
        	min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
