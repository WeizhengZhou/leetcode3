package xx;

public class RemoveDuplicatesSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null){return null;}
		int last=head.val+1;
		boolean isDup=true;
		ListNode dummy=new ListNode(0);
		ListNode tail=dummy;
		ListNode pre=dummy;
		ListNode cur=head;
		while(cur!=null){
			if(cur.val!=last){
				if(!isDup){
					tail.next=pre;
					tail=tail.next;
				}
				else{isDup=false;}
			}
			else{
				isDup=true;
			}
			pre=cur;
			last=cur.val;
			cur=cur.next;
		}
		if(!isDup){tail.next=pre;tail=tail.next;}
		tail.next=null;
		return dummy.next;
	}
}
