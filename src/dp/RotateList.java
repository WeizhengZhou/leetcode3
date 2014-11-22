package dp;

public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode rotateRight(ListNode head, int n) {
        int len=length(head);
        if(head==null){
        	return null;
        }
        n=n%len;
        if(n==0){
        	return head;
        }
        ListNode pre=null;
        ListNode fastPre=null;
        ListNode fast=head;
        for(int i=0; i<n;i++){
        	if(fast==null){
        		return head;
        	}
        	fastPre=fast;
        	fast=fast.next;
        }
        ListNode cur=head;
        if(fast==null){
        	return head;
        }
        while(fast!=null){
        	pre=cur;
        	cur=cur.next;
        	fastPre=fast;
        	fast=fast.next;
        }
        fastPre.next=head;
        pre.next=null;
        return cur;
    }
    private int length(ListNode head){
		int length = 0;
        while(head != null){
			length++;
            head = head.next;
		}
        return length;
	}
}
