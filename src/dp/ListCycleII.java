package dp;

public class ListCycleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode detectCycle(ListNode head) {
        if(head==null){
        	return null;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(slow!=fast ){
        	if(slow==null||fast==null||fast.next==null){
        		return null;
        	}
        	slow=slow.next;
        	fast=fast.next.next;
        }
        fast=head;
        slow=slow.next;
        while(slow!=fast){
        	slow=slow.next;
        	fast=fast.next;
        }
        return slow;
    }
}
