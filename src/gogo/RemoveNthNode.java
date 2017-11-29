package gogo;

public class RemoveNthNode {
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode end = head;
        for (int i=0;i<n;i++) {
        	end=end.next;
        }
        ListNode cur=dummy;
        while (end != null) {
        	cur = cur.next;
        	end = end.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
