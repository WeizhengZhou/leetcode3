package xx;

public class LinkedListCycle {
	public class Solution {
	    public boolean hasCycle(ListNode head) {
				if(head==null || head.next==null){
		return false;
	}
	ListNode slow=head;
	ListNode fast=head.next;
	while(slow!=fast){
		slow=slow.next;
		if(fast.next==null || fast.next.next==null){return false;}
		else{
			fast=fast.next.next;
	}
	}
	return true;
	    }
	}
}
