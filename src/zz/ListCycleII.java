//zz reviewed
package zz;

public class ListCycleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public ListNode detectCycle(ListNode head) {
		 if(head==null || head.next==null){
			 return null;
		 }
		 ListNode slow=head;
		 ListNode fast=head;
		 while(slow!=fast){
			 slow=slow.next;
			 fast=fast.next.next;
			 if(fast==null || fast.next==null){
				 return null;
			 }
		 }
		 slow=head;
		 while(slow!=fast){
			 slow=slow.next;
			 fast=fast.next;
		 }
		 return slow;
	 }

}
