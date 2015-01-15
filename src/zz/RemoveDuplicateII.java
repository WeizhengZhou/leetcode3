package zz;

public class RemoveDuplicateII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public ListNode deleteDuplicates(ListNode head) {
		 if(head==null){
			 return null;
		 }
		 ListNode dummyHead=new ListNode(0);
		 ListNode cur=dummyHead;
		 long pre=Long.MAX_VALUE;
		 while(head!=null){
			 if(head.next==null){
				 if(head.val!=pre){
					 cur.next=head;
					 cur=cur.next;
				 }				 
				 break;
			 }
			 if(head.val!=head.next.val){
				 cur.next=head;
				 cur=cur.next;
				 head=head.next;
			 }
			 else{
				 while(head!=null && head.next!=null && head.val==head.next.val){
					 head=head.next;
					 pre=head.val;
				 }
				 if(head!=null){
					 head=head.next;
				 }
			 }
		 }
		 cur.next=null;
		 return dummyHead.next;
	 }

}
