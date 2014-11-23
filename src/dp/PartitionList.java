package dp;

public class PartitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(2);
		ListNode l2=new ListNode(1);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(2);
		ListNode l5=new ListNode(5);
		l1.next=l2;
		/*l2.next=l3;
		l3.next=l4;
		l4.next=l5;*/
		PartitionList re=new PartitionList();
		ListNode r=re.partition(l1, 2);
		while(r!=null){
			System.out.println(r.val);
			r=r.next;
		}

	}
    public ListNode partition(ListNode head, int x) {
        if(head==null){
        	return head;
        }
        ListNode largeHead=new ListNode(0);
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=head;
        ListNode large=largeHead;
        while(cur!=null){
        	System.out.println(cur.val);
        	System.out.println("large="+large.val+",cur="+cur.val+",pre="+pre.val);
        	if(cur.val<x){
        		pre=cur;
        		System.out.println(cur.val+"<"+x);
        		cur=cur.next;
        		
        	}
        	else{
        		large.next=cur;
        		pre.next=cur.next;
        		System.out.println("large="+large.val+",cur="+cur.val+",pre="+pre.val);
        		large=large.next;  
        		//large.next=null;
        		cur=cur.next;
        		
        		
        	}
        }
        large.next=null;
        pre.next=largeHead.next;
        return dummy.next;
    }
}
