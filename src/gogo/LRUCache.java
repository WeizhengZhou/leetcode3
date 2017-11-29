package gogo;

import java.util.HashMap;
import java.util.Map;
// not pass OJ 
public class LRUCache {
    class Node {
	int key;
	int val;
	Node pre;
	Node next;
	Node (int k, int x) {
		val=x;
		key=k;
	}
}

	int max;
	int size;
	Map<Integer, Node> map;
	Node dummy;
	Node last;
    public LRUCache(int capacity) {
    	max = capacity;
    	size=0;
    	dummy=new Node(0,0);
    	last=dummy;
    	map = new HashMap<> ();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
        	return -1;
        } else {
        	Node n=map.get(key);
        	if (n.next==null) {
        		n.pre.next=null;
        		last=n.pre;
                n.next=null;
        	} else {
        		n.pre.next = n.next;
        		n.next.pre = n.pre;
        	}
        	Node next=dummy.next;
          	if (next!=null) {
              	next.pre=n;
              	n.next=next;
          	} else {
          		last=n;
                n.next=null;
          	}
            dummy.next=n;
          	n.pre=dummy;
        	return n.val;
        }
    }
    //["LRUCache","put","put","put","put","get","get"]
//[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
    public void put(int key, int value) {//[2,1],[1,1],[2,3]
        Node n=null;
        if(!map.containsKey(key)) {
            if (size<max) {
              	size++;//1,2
            } else {
            	map.remove(last.key);
            	last.pre.next=null;
            	last = last.pre;
            }
            n = new Node(key, value);
            map.put(key, n);//[2,1][1,1]
        } else {
            n = map.get(key);//[2,1]
    		n.val=value;//[2,3]
            map.put(key,n);
            Node next = n.next;
            if (next !=null) {
                n.pre.next=next;
                next.pre=n.pre;
            } else {
                n.pre.next=null;//dummy<->[1,1] --last
                last=n.pre;
            }
        }
        if (n.pre != dummy) {
            Node next=dummy.next;
            if (next!=null) {//dummy<->[1,1]<->[2,1] --last
                next.pre=n;
                n.next=next;
            } else {//dummy<->[2,1]---last
                last=n;
                n.next=null;
            }
            dummy.next=n;
            n.pre=dummy;
        }
        
    }
}
