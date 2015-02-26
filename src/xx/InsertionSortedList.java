package xx;

public class InsertionSortedList {
	public ListNode insertionSortList(ListNode head) {
		if(head==null)return null;
		ListNode dummy=new ListNode(Integer.MIN_VALUE);
		ListNode cur=head;
		while(cur!=null){
			ListNode next=cur.next;
			insert(dummy,cur);
			cur=next;
		}
		return dummy.next;
	}
	private void insert(ListNode dummy,ListNode node){
		ListNode insertPre=dummy;
		while(insertPre.next!=null && insertPre.next.val<=node.val){
			insertPre=insertPre.next;
		}
		node.next=insertPre.next;
		insertPre.next=node;
	}
}
