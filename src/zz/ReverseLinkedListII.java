package zz;

public class ReverseLinkedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null || m==n){
			return head;
		}
		ListNode dummyHead=new ListNode(0);
		dummyHead.next=head;
		ListNode preReverse=dummyHead;
		ListNode reverseStart=head;
		ListNode reverseEnd=head;
		ListNode afterReverse=head;
		int i=1;
		for(;i<m;i++){
			preReverse=reverseStart;
			reverseStart=reverseStart.next;
			reverseEnd=reverseEnd.next;
		}
		for(;i<n;i++){
			reverseEnd=reverseEnd.next;
		}
		afterReverse=reverseEnd.next;
		reverseEnd.next=null;
		ListNode cur=reverseStart.next;
		ListNode pre=reverseStart;
		ListNode next=null;
		while(cur!=null){
			next=cur.next;
			cur.next=pre;
			pre=cur;
			cur=next;			
		}
		preReverse.next=reverseEnd;
		reverseStart.next=afterReverse;
		return dummyHead.next;
	}

}
