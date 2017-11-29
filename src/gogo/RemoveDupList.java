package gogo;

public class RemoveDupList {
	public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode it = head;
        while(it != null) {
        	cur.next = it;
    		cur = it;
    		while (it.next!=null && it.val == it.next.val) {
    			it = it.next;
    		}
    		it = it.next;     	
        }
        cur.next = null;
        return dummy.next;
    }
}
