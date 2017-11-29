package gogo;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null) return head;
		ListNode odd=head;
		ListNode even=head.next;
		ListNode evenStart=even;
		ListNode i=even.next;
		while(i!=null) {
			odd.next=i;
		    odd=odd.next;
			i=i.next;        	
			if (i!=null) {
				even.next=i;
		        even=even.next;
				i=i.next;
			}
		}
		even.next=null;
		odd.next=evenStart;
		return head;
    }
}
