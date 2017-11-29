//zz reviewed
//Hard problem, discuss

package zz;

import java.util.HashMap;
import java.util.Map;

public class LRUcache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUcache l=new LRUcache(2);
		l.set(2, 1);
		l.set(2, 2);
		//System.out.println(l.get(2));
		//System.out.println(l.get(2));
		l.set(1, 1);
		l.set(4, 1);
		System.out.println(7&5);
		//System.out.println(l.get(3));
		//l.set(2, 3);
		//l.set(4, 1);
		
		
	}
	
	class ListNode{//zz, simply node, or DNode
		int key;
		int val;
		ListNode pre;
		ListNode next;
		ListNode(int x, int y){//zz, (int key, int val){this.key = key;this.val = val;}
			key=x;
			val=y;
		}
	}
	
	ListNode dummy=new ListNode(0,0);//zz, private field!!, not protected field
					//zz, head with tail
	Map<Integer,ListNode> map;//zz, private
	int size;//zz, size is the number of items in this collectin
		//zz, capacity is the number of items this collection can hold
	ListNode last=dummy;//zz, tail
	
	public LRUcache(int capacity){
		map=new HashMap<Integer,ListNode>(capacity);//zz, new object<no type>
		size=capacity;//zz, this.size = capacity
	}
	
	public void set(int key, int value){
		//zz, logic
		if(map.containsKey(key)){
			ListNode node=map.get(key);
			node.val=value;
			map.put(key, node);
			if(node.pre!=dummy){//zz, duplicate code
				if(last==node){
					last=node.pre;
					//System.out.println("contains set key "+ key+" last Node="+last.key);
				}
				node.pre.next=node.next;
				if(node.next!=null)
				{
					node.next.pre=node.pre;
				}
				node.next=dummy.next;
				if(dummy.next!=null)
				{
					dummy.next.pre=node;
				}
				dummy.next=node;
				node.pre=dummy;
			}
		}
		else{
			if(map.size()<size){//zz, this.size < capacity, you mis-understand the meaning of size
				ListNode n=new ListNode(key,value);
				n.next=dummy.next;
				dummy.next=n;
				n.pre=dummy;
				if(n.next!=null)
				{
					n.next.pre=n;
				}
				//System.out.println("set key "+ key+" last Node="+last.key);
				if(last==dummy){
					last=n;
				}
				//System.out.println("set key "+ key+" last Node="+last.key);
				map.put(key, n);
			}
			else{//zz, write a function for this obvious independent block
			     //zz, call function evictTailNode()
				ListNode delete=last;
				map.remove(delete.key);
				last=last.pre;
				//System.out.println("set key "+key+" last Node="+last.key);
				last.next=null;
				
				ListNode n=new ListNode(key,value);
				n.next=dummy.next;
				dummy.next=n;
				n.pre=dummy;
				if(n.next!=null)
				{
					n.next.pre=n;
				}
				map.put(key, n);
			}
		}
	}
	
	public int get(int key){
		if(map.isEmpty()){
    		return -1;
    	}
        if(!map.containsKey(key)){
        	return -1;
        }
		ListNode n=map.get(key);
		if(n.pre!=dummy){//zz, write a function, moveNodeToHead(), which makes code easier to read and maintain
			//System.out.println("get key "+key+" last Node="+last.key);
			if(n==last){
				last=n.pre;
			}
			//System.out.println(key+" last Node="+last.key);
			n.pre.next=n.next;
			if(n.next!=null){
				n.next.pre=n.pre;
			}
			n.next=dummy.next;
			if(dummy.next!=null)
			{
				dummy.next.pre=n;
			}
			dummy.next=n;
		
			n.pre=dummy;
		}
		return n.val;
	}

}
