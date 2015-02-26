package xx;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if(head==null){
			return null;
		}
		ListNode smallDummyHead=new ListNode(0);
		ListNode smallTail=smallDummyHead;
		ListNode largeHead=new ListNode(0);
		ListNode largeTail=largeHead;
		ListNode cur=head;
		while(cur!=null){
			if(cur.val<x){
				smallTail.next=cur;
				smallTail=smallTail.next;
			}
			else{
				largeTail.next=cur;
				largeTail=largeTail.next;
			}
			cur=cur.next;
		}
		largeTail.next=null;
		smallTail.next=largeHead.next;
		return smallDummyHead.next;
	}
}
