package gogo;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class RemoveDupListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode it = head;
        while(it != null) {
        	if (it.next==null || it.val != it.next.val) {
        		cur.next = it;
        		cur = it;
        		it = it.next;
        	} else {
        		while (it.next!=null && it.val == it.next.val) {
        			it = it.next;
        		}
        		it = it.next;
        	}       	
        }
        cur.next = null;
        return dummy.next;
    }
}
