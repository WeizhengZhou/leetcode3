package xx;

public class SwapNodesPairs {
	 public ListNode swapPairs(ListNode head) {
	        if(head==null) return head;
	        ListNode dummy=new ListNode(0);
	        ListNode reversePre=dummy;
	        dummy.next=head;
	        ListNode first=head;
	        ListNode second=head.next;
	        ListNode reverseNext=null;
	        while(second!=null){
	            reverseNext=second.next;
	            reversePre.next=second;
	            second.next=first;
	            first.next=reverseNext;
	            reversePre=first;
	            first=reverseNext;
	            second=first==null?null:first.next;
	        }
	        return dummy.next;
	    }
}
