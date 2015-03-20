package xx;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	       if(l1==null || l2==null){
	           return l1==null?l2:l1;
	       }
	       int carry=0;
	       ListNode dummy=new ListNode(0);
	       ListNode cur=dummy;
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
	           cur=cur.next;
	           carry=carry/10;
	       }
	       if(carry!=0){
	           cur.next=new ListNode(carry);
	       }
	       return dummy.next;
	    }
}
