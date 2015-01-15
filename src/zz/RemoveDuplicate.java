package zz;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public ListNode deleteDuplicates(ListNode head) {
		 if(head==null){
			 return null;
		 }
		 ListNode dummyhead=new ListNode(0);
		 ListNode cur=dummyhead;
		 while(head!=null){
			 cur.next=head;
			 cur=cur.next;
			 int x=head.val;
			 while(head!=null && head.val==x){
				 head=head.next;
			 }
		 }
		 cur.next=null;
		 return dummyhead.next;
	 }

}
