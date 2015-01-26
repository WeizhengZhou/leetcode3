package zz;

public class ReverseKGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public ListNode reverseKGroup(ListNode head, int k) {
		 if(head==null || head.next==null || k<=1){
			 return head;
		 }
		 ListNode dummy=new ListNode(0);
		 dummy.next=head;
		 ListNode reversePre=dummy;
		 ListNode pre=dummy;
		 ListNode cur=head;
		 ListNode reverseNext=dummy;
		 while(cur!=null){
			 int count=k;
			 pre=reversePre;
			 cur=pre.next;
			 while(cur!=null && count>0){
				 pre=cur;
				 cur=cur.next;
				 count--;
			 }
			 if(count>0){
				 break;
			 }
			 pre.next=null;
			 reverseNext=cur;
			 reversePre=reverse(reversePre,reverseNext);
		 }
		return dummy.next;		
	 }
	 
	 public ListNode reverse(ListNode reversePre,ListNode reverseNext){		 
		 ListNode pre=reversePre.next;
		 ListNode cur=pre.next;
		 ListNode next=cur.next;
		 ListNode tail=pre;
		 pre.next=reverseNext;
		 while(cur!=null){
			 next=cur.next;
			 cur.next=pre;
			 pre=cur;
			 cur=next;
		 }
		 reversePre.next=pre;
		 return tail;		 
	 }

}
