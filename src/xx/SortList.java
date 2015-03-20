package xx;

public class SortList {
	public ListNode sortList(ListNode head) {
		 if(head==null){return null;}
		 if(head.next==null){return head;}
		 //ListNode pre=head;
		 ListNode slow=head;
		 ListNode fast=head.next;
		 while(fast!=null&&fast.next!=null){
		     //pre=slow;
		     slow=slow.next;
		     fast=fast.next.next;
		 }
		 ListNode leftHead=head;
		 ListNode rightHead=slow.next;
		 slow.next=null;
		 ListNode left=sortList(leftHead);
		 ListNode right=sortList(rightHead);
		 ListNode dummy=new ListNode(0);
		 ListNode tail=dummy;
		 while(left!=null && right!=null){
		     if(left.val<=right.val){
		         tail.next=left;
		         left=left.next;
		     }
		     else{
		         tail.next=right;
		         right=right.next;
		     }
		     tail=tail.next;
		 }
		 tail.next=left==null?right:left;
		 return dummy.next;
   }
}
