package gogo;

import java.util.Comparator;
import java.util.PriorityQueue;

import gogo.RemoveNthNode.ListNode;

public class MergeKList {
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	public ListNode mergeKLists(ListNode[] lists) {
	       if (lists == null || lists.length == 0) return null;
	       PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
	    	   @Override
	   		public int compare(ListNode x, ListNode y) {
	   			return x.val - y.val;
	   		}
	       });
	       for (int i= 0; i<lists.length; i++) {
	           if (lists[i] != null) {
	               heap.add(lists[i]);
	           }	   
	       }
	       ListNode dummy = new ListNode(0);
	       ListNode cur=dummy;
	       while(!heap.isEmpty()) {
	    	   ListNode next = heap.poll();
	    	   if (next.next != null) heap.add(next.next);
	    	   cur.next = next;
	    	   cur = next;
	       }
	       return dummy.next;
		}
}
	

