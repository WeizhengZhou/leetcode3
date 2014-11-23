package dp;

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		/*l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;*/
		ReorderList re=new ReorderList();
		re.reorderList(l1);
		while(l1!=null){
			System.out.println(l1.val);
			l1=l1.next;
		}
	}
	public void reorderList(ListNode head) {
        if(head==null){
        	return;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
        	pre=slow;
        	slow=slow.next;
        	fast=fast.next.next;
        }
        ListNode end=null;
        ListNode start=null;       
    	end=slow;
    	start=slow.next;
    	if(start==null){
    		return;
    	}
        end.next=null;
        //System.out.println("end="+end.val+",start="+start.val);
        ListNode cur=start.next;
        pre=start;
        start.next=null;
        while(cur!=null){
        	ListNode next=cur.next;
        	cur.next=pre;
        	pre=cur;
        	cur=next;
        }
        cur=pre;
        while(cur!=null){
        	//System.out.println("cur="+cur);
        	ListNode next=head.next;
        	head.next=cur;
        	ListNode n=cur.next;
        	cur.next=next;
        	cur=n;
        	head=next;
        }
    }
}
