package xx;

public class RotateList {
	 public ListNode rotateRight(ListNode head, int n) {
		    if(head==null || n<=0)return head;
		    int len=length(head);
		    int k=n%len;
		    if(k==0)return head;
		    ListNode dummy=new ListNode(0);
		    dummy.next=head;
		    ListNode fast=head;
		    ListNode slow=head;
		    ListNode preFast=dummy;
		    ListNode preSlow=dummy;
		    int count=0;
		    while(fast!=null){
		        if(count>=k){preSlow=slow;slow=slow.next;}
		        count++;
		        preFast=fast;
		        fast=fast.next;
		    }
		        preSlow.next=null;
		        preFast.next=dummy.next;
		    return slow;
	    }
	    private int length(ListNode head){
	        int len=0;
	        while(head!=null){
	            len++;
	            head=head.next;
	        }
	        return len;
	    }
}
