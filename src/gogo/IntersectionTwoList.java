package gogo;

import additional.ListNode;

public class IntersectionTwoList {
	 class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null) return null;
        ListNode a=headA;
        ListNode b=headB;
        while(a!=null && b!=null) {
        	a=a.next;
        	b=b.next;
        }
        ListNode longer=headA;
        ListNode shorter=headB;
        if (a!=null) {
        	longer=headA;
        	while(a!=null) {
        		a=a.next;
        		longer=longer.next;
        	}
        	shorter = headB;
        }
        if (b!=null) {
        	longer=headB;
        	while(b!=null) {
        		b=b.next;
        		longer=longer.next;
        	}
        	shorter = headA;
        }
        while (longer!=shorter){
        	longer=longer.next;
        	shorter=shorter.next;
        }
        return longer;
    }
}
