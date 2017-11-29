package gogo;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SkyLine {
	class Node {
		int x;
		int h;
		Node(int xx, int hh) {
			x=xx;
			h=hh;
		}
		public int compare(Node n1, Node n2) {
			return n1.x-n2.x;
		}
	}
    public List<int[]> getSkyline(int[][] buildings) {
    	List<int[]> list = new LinkedList<> ();
    	if (buildings==null||buildings.length==0) return list;
    	Queue<Node> plus = new PriorityQueue<Node> (buildings.length, new Comparator<Node> () {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if (o1.x!=o2.x) return o1.x-o2.x;
				return o2.h - o1.h;
			}   		
    	});
    	for(int i=0;i<buildings.length;i++) {
    		plus.add(new Node(buildings[i][0], buildings[i][2]));
    	}
    	Queue<Node> minus = new PriorityQueue<Node> (buildings.length, new Comparator<Node> () {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if (o1.x!=o2.x) return o1.x-o2.x;
				return o1.h-o2.h;
			}   		
    	});
    	for(int i=0;i<buildings.length;i++) {
    		minus.add(new Node(buildings[i][1], buildings[i][2]));
    	}
    	PriorityQueue<Integer> height=new PriorityQueue<> (buildings.length, new Comparator<Integer> () {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}   		
    	});
    	while(!plus.isEmpty() || !minus.isEmpty()) {
    		Node add=plus.peek();
    		Node remove=minus.peek();
    		int curH=height.isEmpty()?0:height.peek();
    		if (add!=null && remove!=null) {    			
    			if (add.x<remove.x){
    				plus.poll();   	    		
    	    		if (add.h>curH) {
    	    			list.add(new int[] {add.x, add.h});
    	    		}
    	    		height.add(add.h);
    			} else if (add.x>remove.x) {
    				minus.poll();    				
    				height.remove(remove.h);System.out.println("remove x="+remove.x+" ,remove h="+remove.h);
    				System.out.println("curH="+curH);
    				if (remove.h==curH) {System.out.println(1);
    					int nextH=0;
    					if (!height.isEmpty()) nextH=height.peek();
    					if (nextH!=curH) {
    						list.add(new int[] {remove.x, nextH});
    					}
    				}	
    			} else {
    				plus.poll();    	    		
    	    		if (add.h>curH) {
    	    			list.add(new int[] {add.x, add.h});
    	    		}
    	    		height.add(add.h);
    	    		minus.poll();
    				curH=height.isEmpty()?0:height.peek();
    				height.remove(remove.h);
    				if (remove.h==curH) {   					
    					int nextH=0;
    					if (!height.isEmpty()) nextH=height.peek();
    					if (nextH!=curH){
    						list.add(new int[] {remove.x, nextH});
    					}
    				}	
    			}
    		} else if (remove!=null) {
    			minus.poll();				
				height.remove(remove.h);
				if (remove.h==curH) {		
					int nextH=0;
					if (!height.isEmpty()) nextH=height.peek();
					if (nextH!=curH) {
						list.add(new int[] {remove.x, nextH});
					}
				}
				
    		}

    	}
    	return list;
    }
    
    
    
    
    
}
