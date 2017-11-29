package gogo;

import java.util.Stack;

public class MinStack {
	Stack<Integer> min;
	Stack<Integer> s;
    /** initialize your data structure here. */
    public MinStack() {
    	min = new Stack<> ();
    	s = new Stack<> ();
    }
    
    public void push(int x) {
        s.push(x);
        if(min.isEmpty() || min.peek()>=x) {
        	min.push(x);
        }
    }
    
    public void pop() {
        int top = s.pop();
        if (min.peek()==top) {
        	min.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
