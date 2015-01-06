package zz;

public class ListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean hasCycle(ListNode head) {
		if(head==null || head.next==null){
			return false;
		}
		ListNode slow=head;
		ListNode fast=head.next;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				return true;
			}
		}
		return false;
	}

}
