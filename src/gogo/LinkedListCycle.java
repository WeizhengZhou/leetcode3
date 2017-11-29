package gogo;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null) return true;
        ListNode first=head;
        ListNode second = head.next;
        while(first != second) {
        	first = first.next;
        	second = second.next==null ? null : second.next.next;
        	if (first==null || second==null) return false;
        }
        return true;
    }
}
