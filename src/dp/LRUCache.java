package dp;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache l=new LRUCache(2);
		l.set(2, 1);
		
		//System.out.println(l.get(2));
		l.set(1, 1);
		l.set(2, 3);
		l.set(4, 1);
		System.out.println(l.get(1));
		System.out.println(l.get(2));
	}
	private class ListNode {
	     int val;
	     int key;
	     ListNode pre;
	     ListNode next;
	     ListNode(int k, int x) { val = x; key=k; next = null; pre=null;}
	}
	ListNode dummy=new ListNode(-1,-1);
	int cap=0;
	Map<Integer, ListNode> map=null;
	ListNode tail=new ListNode(100,100);
	
	public void print(ListNode h){
		while(h!=null){
			System.out.print("("+h.key+","+h.val+") ");
			h=h.next;
		}
	}
    
	public LRUCache(int capacity) {
        this.map=new HashMap<Integer,ListNode>(capacity);
        cap=capacity;
        dummy.next=tail;
        tail.pre=dummy;
    }
    
    public int get(int key) {
    	ListNode get;
    	if(map.isEmpty()){
    		return -1;
    	}
        if(!map.containsKey(key)){
        	return -1;
        }
        else{
        	get=map.get(key);
        	get.pre.next=get.next;
        	get.next.pre=get.pre;
        	get.next=dummy.next;
        	get.next.pre=get;
        	get.pre=dummy;
        	dummy.next=get;
        	//System.out.println("Key Set:");
            for(int k:map.keySet()){
            	//System.out.print(k+" ");
            }
            //System.out.println("");
        	return get.val;
        }
    }
    
    public void set(int key, int value) {
    	//print(dummy);
    	if(!map.containsKey(key)){
    		ListNode n=new ListNode(key, value);
        	n.next=dummy.next;
        	n.next.pre=n;
        	n.pre=dummy;
        	dummy.next=n;
        	//System.out.println("map size="+map.size()+", capacity="+cap);
	        if(map.size()==cap){
	        	ListNode last=tail.pre;
	        	//System.out.println("tail key="+tail.key);
	        	int lastKey=last.key;
	        	//System.out.println("last key="+last.key+",last value="+last.val);
	        	map.remove(lastKey);
	        	last.pre.next=tail;
	        	tail.pre=last.pre;
	        	//System.out.println("map size="+map.size()+", capacity="+cap);
	        }
	        
	        map.put(key, n);	        
    	}
    	else{
    		ListNode get=map.get(key);
        	get.pre.next=get.next;
        	get.next.pre=get.pre;
        	get.next=dummy.next;
        	get.next.pre=get;
        	get.pre=dummy;
        	dummy.next=get;
    		map.get(key).val=value;
    	}
        
    }
}
