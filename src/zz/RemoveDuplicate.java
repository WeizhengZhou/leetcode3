//zz reviewed
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
		 ListNode cur=dummyhead;//zz name -> tail
		//zz ListNode cur = head;
		 while(head!=null){//zz while(cur != null)
			 cur.next=head;//zz tail.next = cur;
			 cur=cur.next;//zz tail = tail.next;
			 int x=head.val;//zz cur = cur.next;//zz x here is not meaningful and not necessary:e

			 while(head!=null && head.val==x){//zz while(cur != null && cur.val = tail.val) cur = cur.next
				 head=head.next;
			 }
		 }
		 cur.next=null;
		 return dummyhead.next;
	 }

}
