package zz;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 if(l1==null || l2==null){
			 return l1==null?l2:l1;
		 }
		 ListNode dummy=new ListNode(0);
		 ListNode cur=dummy;
		 int carry=0;
		 while(l1!=null || l2!=null){
			 if(l1!=null){
				 carry+=l1.val;
				 l1=l1.next;
			 }
			 if(l2!=null){
				 carry+=l2.val;
				 l2=l2.next;
			 }
			 cur.next=new ListNode(carry%10);
			 carry=carry/10;
			 cur=cur.next;
		 }
		 if(carry!=0){
		     cur.next=new ListNode(carry);
		 }
		 return dummy.next;
	 }
}
