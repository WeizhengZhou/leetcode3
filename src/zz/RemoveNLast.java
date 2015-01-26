package zz;

public class RemoveNLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public ListNode removeNthFromEnd(ListNode head, int n) {
		 if(head==null){
			 return null;
		 }
		 ListNode dummy=new ListNode(0);
		 dummy.next=head;
		 ListNode pre=dummy;
		 ListNode del=head;
		 ListNode end=head;
		 while(end!=null){
			 if(n>0){
				 end=end.next;
				 n--;
			 }
			 else{
				 pre=del;
				 del=del.next;
				 end=end.next;
			 }
		 }
		 pre.next=del.next;
		 return dummy.next;
	 }

}
