package dp;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){
        	return l1==null?l2:l1;
        }
        int carry=0;
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        while(l1!=null&&l2!=null){
        	int sum=l1.val+l2.val+carry;
        	cur.next=new ListNode(sum%10);
        	carry=sum/10;
        	cur=cur.next;
        	l1=l1.next;
        	l2=l2.next;
        }
        ListNode remain=l1==null?l2:l1;
        while(remain!=null){
        	int sum=remain.val+carry;
        	cur.next=new ListNode(sum%10);
        	carry=sum/10;
        	cur=cur.next;
        	remain=remain.next;
        }
        if(carry!=0){
        	cur.next=new ListNode(carry);
        }
        return dummy.next;
    }
}
