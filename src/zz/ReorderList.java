package zz;

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n=new ListNode(1);
		n.next=new ListNode(2);
		n.next.next=new ListNode(3);
		n.next.next.next=new ListNode(4);
		ReorderList r=new ReorderList();
		r.reorderList(n);
		while(n!=null){
			System.out.println(n.val);
			n=n.next;
		}
		
		

	}
	 public void reorderList(ListNode head) {
		 if(head==null || head.next==null){
			 return;
		 }
		 //ListNode pre=null;
		 ListNode slow=head;
		 ListNode fast=head.next;
		 while(fast!=null && fast.next!=null){
			 //pre=slow;
			 slow=slow.next;
			 fast=fast.next.next;
		 }
		 if(slow.next==null){//////!!!!
			 return;
		 }
		 ListNode dummy=new ListNode(0);
		 ListNode last=slow.next;
		 ListNode cur=slow.next.next;
		 slow.next=null;
		 last.next=null;/////!!!!
		 ListNode next;
		 while(cur!=null){
			 next=cur.next;
			 cur.next=last;
			 last=cur;
			 cur=next;		 
		 }
		 ListNode iterator=dummy;
		 ListNode first=head;
		 /*ListNode n=first;
		 
		 while(n!=null){
				System.out.println(n.val);
				n=n.next;
			}*/
		 ListNode second=last;
		 /*n=second;
		 System.out.println(" ");
		 while(n!=null){
				System.out.println(n.val);
				n=n.next;
			}*/
		 while(first!=null && second!=null){			 
				 iterator.next=first;
				 first=first.next;
				 iterator=iterator.next;
				 //System.out.println(iterator.val);
				 iterator.next=second;
				 second=second.next;
				 iterator=iterator.next;
				 //System.out.println(iterator.val);
		 }
		 iterator.next=first==null?second:first;
	 }

}
