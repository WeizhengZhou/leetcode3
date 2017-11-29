package gogo;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head==null || head.next==null || head.next.next==null) return;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode first = head;
        ListNode second = head.next;
        while (second != null) {
        	pre=pre.next;
        	first = first.next;
        	second = second.next==null?null:second.next.next;
        }
        pre.next = null;
        second=first;
        ListNode last=second;
        ListNode cur=last==null?null:last.next;
        ListNode next=cur==null?null:cur.next;
        while(cur!=null) {
        	cur.next=last;
        	last=cur;
        	cur=next;
        	next=next==null?null:next.next;
        }
        second.next=null;
        second = last;
        first = head;
        cur=dummy;
        while(second!=null || first!=null) {
        	if (first!=null) {
            	cur.next = first;
            	first=first.next;
            	cur=cur.next;
        	}
        	if (second!=null) {
            	cur.next=second;
            	second=second.next;
            	cur=cur.next;
        	}
        }
    }
}
