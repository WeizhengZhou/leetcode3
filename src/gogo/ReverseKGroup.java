package gogo;

import gogo.MergeKList.ListNode;

public class ReverseKGroup {
	class Pair {
		ListNode start;
		ListNode end;
		Pair(ListNode l1, ListNode l2) {
			start = l1;
			end = l2;
		}
	}
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}
	public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || k<=1) return head;
        ListNode dummy =new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = head;
        ListNode last = head;
        while (next!=null) {
        	for (int i=0; i<k; i++) {
        		if (next == null) return dummy.next;
        		last = next;
        		next = next.next;        		
        	}
        	last.next = null;
        	Pair p = reverseHelper(cur, k);
        	pre.next = p.start;
        	p.end.next = next;
        	cur = next;
        	pre=p.end;
        }
        return dummy.next;
    }
	private Pair reverseHelper(ListNode head, int k) {
		ListNode first = head;
		ListNode second = head.next;
		ListNode next = second==null? null : second.next;
		while(second != null) {
			second.next = first;
			first = second;
			second = next;
			next = second==null? null : second.next;
		}
		return new Pair(first, head);
	}
}
