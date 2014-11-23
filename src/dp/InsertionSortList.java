package dp;

public class InsertionSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(3);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(1);
		ListNode l4=new ListNode(2);
		ListNode l5=new ListNode(5);
		l1.next=l2;
		l2.next=l3;
		/*l3.next=l4;
		l4.next=l5;*/
		InsertionSortList re=new InsertionSortList();
		ListNode r=re.insertionSortList(l1);
		while(r!=null){
			System.out.println(r.val);
			r=r.next;
		}
	}
    public ListNode insertionSortList(ListNode head) {
        if(head==null){
        	return null;
        }
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode it=head;
        ListNode cur=head;
        while(cur!=null){
        	ListNode preIt=dummy;
        	it=dummy.next;
        	while(it!=cur){
        		if(cur.val>=preIt.val && cur.val<it.val){
        			pre.next=cur.next;
        			
        			preIt.next=cur;
        			cur.next=it;
        			System.out.println("while(it!=cur):pre="+pre.val+",cur="+cur.val+",preIt="+preIt.val+",preIt.next="+preIt.next.val+",cur.next="+cur.next.val);
        			break;
        		}
        		preIt=it;
        		it=it.next;
        	}
        	if(it==cur){
        		System.out.println("it==cur:pre="+pre.val+",cur="+cur.val);
        		pre=cur;
            	cur=cur.next;
            	System.out.println("it==cur:pre="+pre.val+",cur="+cur.val);
        	}
        	else{
        		cur=pre.next;
        		//System.out.println("cur="+cur.val);
        	}        	       	
        }
        return dummy.next;
    }
}
