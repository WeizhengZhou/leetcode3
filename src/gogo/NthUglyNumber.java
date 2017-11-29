package gogo;

import java.util.PriorityQueue;

public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        if (n==1) return 1;
        long cur=1;
        PriorityQueue<Long> p2=new PriorityQueue<> ();
        p2.add((long) 2);
        PriorityQueue<Long> p3=new PriorityQueue<> ();
        p3.add((long) 3);
        PriorityQueue<Long> p5=new PriorityQueue<> ();
        p5.add((long) 5);
        for (int i=1;i<n;i++) {
        	if (p2.peek()<p3.peek() && p2.peek()<p5.peek()) {
        		cur=p2.poll();
        		p2.add(cur*2);
        		p3.add(cur*3);
        		p5.add(cur*5);
        	} else if (p3.peek()<p2.peek() && p3.peek()<p5.peek()) {
        		cur=p3.poll();
        		p3.add(cur*3);
        		p5.add(cur*5);
        	} else {
        		cur=p5.poll();
        		p5.add(cur*5);
        	}
        }
        return (int)cur;
    }
}
