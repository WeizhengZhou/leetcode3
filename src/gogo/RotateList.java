package gogo;


public class RotateList {
	class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	public ListNode rotateRight(ListNode head, int k) {
        if (head==null || k<=0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail=head;
        ListNode end = dummy;
        for(int i=0;i<k;i++){
        	tail = tail.next;
        	end = end.next;
        	if (tail== null) return head;
        }
        ListNode cur=dummy;
        while(tail!=null) {
        	cur=cur.next;
        	tail = tail.next;
        	end = end.next;
        }
        head = cur.next;
        end.next=dummy.next;
        cur.next = null;
        return head;
    }
}
