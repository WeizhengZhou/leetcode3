package zz;

public class SwapPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode swapPairs(ListNode head) {
		if(head==null || head.next==null){
			return head;
		}
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode reversePre=dummy;		
		ListNode pre=head;
		ListNode cur=head.next;
		ListNode reverseNext=cur.next;
		while(pre!=null && cur!=null){
			reversePre.next=cur;
			cur.next=pre;
			pre.next=reverseNext;
			reversePre=pre;
			pre=reverseNext;
			if(pre!=null)
			{
				cur=pre.next;
				if(cur!=null){
					reverseNext=cur.next;
				}
			}
			
		}
		return dummy.next;
	}

}
