package dp;

public class SwapNodePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode swapPairs(ListNode head) {
        if(head==null){
        	return null;
        }
        ListNode dummy=new ListNode(0);
        ListNode pre=dummy;
        ListNode cur=head;
        pre.next=cur;
        while(cur!=null && cur.next !=null){
        	ListNode next=cur.next.next;
        	pre.next=cur.next;
        	pre.next.next=cur;
        	cur.next=next;
        	pre=cur;
        	cur=next;
        }
        return dummy.next;
    }
}
