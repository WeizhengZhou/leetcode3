package gogo;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        ListNode pre=dummy;
        dummy.next=head;
        ListNode cur=head;
        ListNode next=cur.next;
        while(cur!=null) {
        	cur.next=pre;
        	pre=cur;
        	cur=next;
        	next=cur==null?null:cur.next;
        }
        head.next=null;
        return pre;
    }
}
