package gogo;

public class InsertionSortList {
	class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
    public ListNode insertionSortList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;
        cur.next=null;
        ListNode it=head.next;
        while(it!=null) {
        	ListNode next=it.next;
        	it.next=null;
        	while(cur!=null && it.val<cur.val) {
        		pre=pre.next;
        		cur=cur.next;
        	}
        	pre.next=it;
        	it.next=cur;
        	it=next;
        }
        return dummy.next;
    }
}
