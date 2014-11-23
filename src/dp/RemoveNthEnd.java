package dp;

public class RemoveNthEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0||head==null){
        	return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode slow=head;
        ListNode fast=head;
        for(int i=0;i<n;i++){
        	if(fast==null){
        		return head;
        	}
        	fast=fast.next;
        }
        while(fast!=null){
        	pre=slow;
        	slow=slow.next;
        	fast=fast.next;       	
        }
        pre.next=slow.next;
        return dummy.next;
    }
}
