package gogo;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
	Queue<Integer> q1;
	Queue<Integer> q2;
	int top;
    /** Initialize your data structure here. */
    public  StackUsingQueue() {
    	q1=new LinkedList<> ();
    	q2=new LinkedList<> ();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        top=x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size()>1) {
        	top=q1.poll();
        	q2.add(top);
        }
        
        int r= q1.poll();
        q1=q2;
        q2=new LinkedList<> ();
        return r;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
