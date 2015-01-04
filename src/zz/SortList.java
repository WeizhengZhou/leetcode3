package zz;

public class SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public ListNode sortList(ListNode head) {
		 if (head==null){
			 return null;
		 }
		 if(head.next==null){
			 return head;
		 }
		 ListNode pre=null;
		 ListNode slow=head;
		 ListNode fast=head.next;
		 while(fast!=null && fast.next!=null){
			 pre=slow;
			 slow=slow.next;
			 fast=fast.next.next;
		 }
		 ListNode left=null;
		 ListNode right=null;
		 if(pre==null){
			 left=head;
			 right=head.next;
			 left.next=null;
		 }
		 else{
			 pre.next=null;
			 left=sortList(head);
			 right=sortList(slow);
		 }
		 ListNode dummyHead=new ListNode(0);
		 ListNode current=dummyHead;
		 while(left!=null && right!=null){
			 if(left.val<=right.val){
				 current.next=left;
				 current=current.next;
				 left=left.next;
			 }
			 else{
				 current.next=right;
				 current=current.next;
				 right=right.next;
			 }
		 }
		 current.next=left==null?right:left;
		 return dummyHead.next;
	 }

}
