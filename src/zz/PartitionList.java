
//zz reviewd
package zz;

public class PartitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode h=new ListNode(2);
		h.next=new ListNode(1);
		PartitionList p=new PartitionList();
		ListNode l=p.partition(h, 2);
		while(l!=null){
			
		}

	}
	
	public ListNode partition(ListNode head, int x) {
		if(head==null){
			return null;
		}
		ListNode smallHead=new ListNode(0);
		ListNode bigHead=new ListNode(0);
		ListNode small=smallHead;
		ListNode big=bigHead;
		while(head!=null){
			if(head.val<x){
				small.next=head;
				small=small.next;
			}
			else{
				big.next=head;
				big=big.next;
			}
			head=head.next;
		}
		small.next=bigHead.next;
		big.next=null;
		return smallHead.next;
	}

}
