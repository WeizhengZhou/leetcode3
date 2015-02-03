//zz reviewed
package zz;

public class SwapPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode swapPairs(ListNode head) {
		if(head==null || head.next==null){
			return head;
		}
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode reversePre=dummy;		
		ListNode pre=head;
		ListNode cur=head.next;
		ListNode reverseNext=cur.next;
		while(pre!=null && cur!=null){
			reversePre.next=cur;
			cur.next=pre;
			pre.next=reverseNext;
			reversePre=pre;
			pre=reverseNext;
			if(pre!=null)//zz this if check can be moved to while
						//zz the logic is, while(pre!= null && pre.next !=null){
						//                     set cur = pre.next;
						//                     do other things
						//				    }
			{
				cur=pre.next;
				if(cur!=null){
					reverseNext=cur.next;
				}
			}			
		}
		return dummy.next;
	}
	
	public ListNode swapPairs_wz(ListNode head){
		if(head == null || head.next == null) return head;
        
        ListNode dh = new ListNode(0);//dummy head
        ListNode tail = dh;//tail of result list
        ListNode one = head;//first node in pair
        ListNode two = null;//second node in pair
        ListNode nextOne = null;//store next One node

        while(one != null && one.next != null){//until has at least two nodes
            two = one.next;//assign two
			nextOne = two.next;//store next one
            tail.next = two;//append two to the tail
            two.next = one;//append one to the tail
            one.next = null;//tail.next == null
            tail = one;//assign new tail
            one = nextOne;//go to next one node
		}
        if(one != null) tail.next = one;//only one node left, append it to the tail
        return dh.next;
	}

}
