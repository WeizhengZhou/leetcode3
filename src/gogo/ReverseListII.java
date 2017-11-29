package gogo;

public class ReverseListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null || head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next = head;
        ListNode preM = dummy;
        ListNode curM = head;
        for (int i=1;i<m;i++) {
        	preM=preM.next;
        	curM = curM.next;    	
        }
        ListNode preN = dummy;
        ListNode curN = head;
        for (int i=0;i<n;i++) {
        	preN = preN.next;
        	curN = curN.next;
        }
        preN.next = null;
        ListNode first=curM;
        ListNode second = first.next;
        ListNode next = second==null? null : second.next;
        while(second!=null) {
        	second.next = first;
        	first=second;
        	second=next;
        	next = second==null? null : second.next;
        }
        preM.next = preN;
        curM.next = curN;
        return dummy.next;
    }
}
