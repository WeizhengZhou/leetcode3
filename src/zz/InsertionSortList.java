package zz;

public class InsertionSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(3);
		head.next=new ListNode(2);
		head.next.next=new ListNode(1);
		InsertionSortList in=new InsertionSortList();
		ListNode s=in.insertionSortList(head);
		while(s!=null){
			System.out.println(s.val);
			s=s.next;
		}

	}
	public ListNode insertionSortList(ListNode head) {
		ListNode iterator=head;
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode pre=null;
		ListNode next=head;
		while(iterator!=null){
				ListNode last=dummy;
				next=dummy.next;
				while(next!=iterator && next.val<iterator.val){
					last=next;
					next=next.next;
				}
				if(next!=iterator){
					pre.next=iterator.next;
					iterator.next=next;
					last.next=iterator;
					iterator=pre;
				}				
			pre=iterator;
			iterator=iterator.next;
		}
		return dummy.next;
	}
}
