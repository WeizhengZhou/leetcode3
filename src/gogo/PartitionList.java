package gogo;

public class PartitionList {
	//[2,1] 2
	public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode less = new ListNode(0);
        ListNode lessCur = less;
        ListNode more = new ListNode(0);
        ListNode moreCur = more;
        ListNode it = head;
        while(it !=null ){
        	if (it.val<x) {
        		lessCur.next = it;
        		lessCur = it;
        	} else {
        		moreCur.next = it;
        		moreCur = it;
        	}
        	it=it.next;
        }
        moreCur.next = null;
        if (less.next == null) return head;
        lessCur.next = more.next;
        return less.next;
    }
}
