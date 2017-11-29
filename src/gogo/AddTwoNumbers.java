package gogo;

public class AddTwoNumbers {
	
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }  
	 

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode r = new ListNode(0);
        ListNode current = r;
        int carry = 0;
        while (l1 != null || l2 != null) {
        	int n1 = l1!=null ? l1.val : 0;
        	int n2 = l2!=null ? l2.val : 0;
            int sum = n1+n2+carry;
        	carry = sum/10;
        	current.next = new ListNode(sum%10);
        	current = current.next;  	
            l1 = l1!=null ? l1.next : null;
            l2 = l2!=null ? l2.next : null;
        }
        if (carry > 0) {
        	current.next = new ListNode(carry);
        }
        return r.next;
    }

}
