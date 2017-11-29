package gogo;

import gogo.MergeKList.ListNode;

public class SwapInPair {
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	public ListNode swapPairs(ListNode head) {
        if (head ==null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode first = head;
        ListNode second = head.next;
        ListNode next = head.next.next;
        while (first != null && second != null) {
        	pre.next = second;
        	second.next = first;
        	first.next = next;
        	pre = first;
        	first = next;
        	second = first ==null ? null: first.next;
        	next  = second == null ? null: second.next;
        }
        return dummy.next;
    }
}
