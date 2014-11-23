package dp;

public class ListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean hasCycle(ListNode head) {
        if(head==null){
        	return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(slow!=fast ){
        	if(slow==null||fast==null||fast.next==null){
        		return false;
        	}
        	slow=slow.next;
        	fast=fast.next.next;
        }
        return true;
    }
}
