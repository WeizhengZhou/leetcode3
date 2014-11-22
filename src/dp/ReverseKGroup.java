package dp;

public class ReverseKGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		l1.next=l2;
		//l2.next=l3;
		//l3.next=l4;
		//l4.next=l5;
		ReverseKGroup re=new ReverseKGroup();
		ListNode r=re.reverseKGroup(l1, 2);
		while(r!=null){
			System.out.println(r.val);
			r=r.next;
		}

	}
	
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1 || head==null){
        	return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode last=dummy;
        ListNode first=dummy.next;
        ListNode cur=head;
        ListNode pre=dummy;
        ListNode next=head;
        for(int i=0;i<k;i++){
        	if(cur==null){
        		break;
        	}
        	pre=cur;
        	cur=cur.next;
        }
        next=cur;
        while(pre!=null){
        	pre.next=null;
        	cur=first.next;
        	first.next=next;
        	pre=first;
        	//System.out.println("last="+last.val+",next="+next.val+",cur="+cur.val);
        	while(cur!=null){
        		ListNode n=cur.next;
        		cur.next=pre;
        		pre=cur;
        		cur=n;
        	}
        	if(next!=null){
	        	last.next=pre;
	        	last=first;
	        	first=next;
	        	cur=first;
	        	//System.out.println("last="+last.val+",next="+next.val+",cur="+cur.val+",first="+first.val);
	        	for(int i=0;i<k;i++){
	            	if(cur==null){
	            		break;
	            	}
	            	pre=cur;
	            	cur=cur.next;
	            }
	        	next=cur;
        	//System.out.println("last="+last.val+",next="+next.val+",cur="+cur.val+",pre="+pre.val);
        	}
        }
        
        return dummy.next;
        
    }
    


}
