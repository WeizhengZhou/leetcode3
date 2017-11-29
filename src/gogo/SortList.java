package gogo;

import gogo.MergeKList.ListNode;
//1,2,3,4,5

public class SortList {
	class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null) {
        	slow=slow.next;
        	fast = fast.next==null ? null : fast.next.next;
        }
        ListNode first = head;
        ListNode second = slow.next;
        slow.next = null;
        first = sortList(head);
        second = sortList(second);
        ListNode cur = dummy;
        while(first!=null || second !=null) {
        	if(first==null || first.val > second.val) {
        		cur.next = second;
        		second = second.next;
        		cur = cur.next;
        		continue;
        	} else {
        		cur.next = first;
        		first = first.next;
        		cur = cur.next;
        		continue;
        	} 
        }
        return dummy.next;
    }
}
