package dp;

public class ReverseListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public ListNode reverseBetween(ListNode head, int m, int n) {
		 if(head==null){
			 return null;
		 }
		 ListNode dummy=new ListNode(0);
		 ListNode before=dummy;
		 ListNode start=head;
		 ListNode end=head;
		 ListNode after=null;
		 ListNode cur=head;		 
		 dummy.next=head;
		 ListNode pre=dummy;
		 for(int i=0; i<n; i++){
			 if(i==m-1){
				 before=pre;
				 start=cur;
			 }
			 pre=cur;
			 cur=cur.next;
		 }
		 end=pre;
		 end.next=null;
		 after=cur;
		 ListNode next=start.next;
		 start.next=after;
		 pre=start;
		 cur=next;
		 while(cur!=null){
			 next=cur.next;
			 cur.next=pre;
			 pre=cur;
			 cur=next;
		 }
		 before.next=pre;
		 return dummy.next;
	 }
}
