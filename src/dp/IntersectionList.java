package dp;

public class IntersectionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
        	return null;
        }
        ListNode cur=headB;
        ListNode next=headB.next;
        while(next!=null){
        	cur=cur.next;
        	next=next.next;
        }
        ListNode tail=cur;
        tail.next=headB;
        ListNode slow=headA;
        ListNode fast=headA.next;
        while(slow!=fast && fast!=null && fast.next!=null){
        	slow=slow.next;
        	fast=fast.next.next;
        }
        if (fast==null || fast.next==null){
        	tail.next=null;
        	return null;
        }
        fast=headA;
        slow=slow.next;
        while(slow!=fast){
        	slow=slow.next;
        	fast=fast.next;
        }
        tail.next=null;
        return slow;
    }
}
