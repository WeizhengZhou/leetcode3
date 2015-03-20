package xx;

public class LInkedListCycleII {
	  public ListNode detectCycle(ListNode head) {
	        if(head==null || head.next==null){return null;}
	        ListNode slow=head;
	        ListNode fast=head.next;
	        while(slow!=fast){
	            if(fast.next==null || fast.next.next==null){return null;}
	            slow=slow.next;
	            fast=fast.next.next;
	        }
	        slow=head;
	        fast=fast.next;
	        while(slow!=fast){
	            slow=slow.next;
	            fast=fast.next;
	        }
	        return slow;
	    }
}
