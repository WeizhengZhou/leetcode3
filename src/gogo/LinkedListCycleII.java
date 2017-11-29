package gogo;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head==null || head.next==null) return null;
        ListNode first = head.next;
        ListNode second = first.next;
        while (first != second) {
        	if (first==null || second==null) return null;
        	first = first.next;
        	second = second.next==null ? null : second.next.next;
        	
        }
        first=head;
        while(first!=second) {
        	first=first.next;
        	second=second.next;
        }
        return first;
    }
}
