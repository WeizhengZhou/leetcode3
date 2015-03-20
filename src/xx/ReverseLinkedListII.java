package xx;

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || m==n){
			return head;
		}
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode pre=null;
	    ListNode cur=head;
	    ListNode next=null;
	    ListNode reversePre=dummy;
	    ListNode reverseStart=null;
	    int i=1;
	    while(i<=n){
	        if(i<m){
	            reversePre=cur;
	            cur=cur.next;
	        }
	        else if(i==m){
	            reverseStart=cur;
	            pre=cur;
	            cur=cur.next;
	        }
	        else if(i<n){
	            next=cur.next;
	            cur.next=pre;
	            pre=cur;
	            cur=next;
	        }
	        else{
	            next=cur.next;
	            cur.next=pre;
	            reversePre.next=cur;
	            reverseStart.next=next;
	        }
	        i++;
	    }
	    return dummy.next;
    }
}
